package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.dto.web.request.MealOrderReqDTO;
import com.ceyentra.sm.dto.web.request.ReservationApproveReqDTO;
import com.ceyentra.sm.dto.web.request.TableReservationReqDTO;
import com.ceyentra.sm.dto.web.response.*;
import com.ceyentra.sm.entity.*;
import com.ceyentra.sm.enums.*;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.repository.*;
import com.ceyentra.sm.service.EmailService;
import com.ceyentra.sm.service.QueryService;
import com.ceyentra.sm.service.ReservationService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final UserRepo customerRepository;
    private final TableReservationRepo tableReservationRepo;
    private final MealOrderRepo mealOrderRepo;
    private final MealsRepo mealsRepo;
    private final MealOrderDetailRepo mealOrderDetailRepo;
    private final RestaurantRepo restaurantRepo;
    private final ModelMapper modelMapper;
    private final QueryRepo queryRepo;
    private final QueryService queryService;
    private final TableReservationDetailRepo tableReservationDetailRepo;
    private final EmailService emailService;
    private final PaymentRepo paymentRepo;

    @PostConstruct
    public void init() {
        Stripe.apiKey = "sk_test_51PtXuxL18030aj4hVq7Y6fEarn0xyqtwWouHUge2IJZE0yN7IsBAYqPxxKguejK4P1VApkirGOw0uyZpJOTtkm1m00UxmzCXF5";
    }

    @Override
    public TableReservationResDTO saveTableReservation(TableReservationReqDTO reqDTO) {
        try {
            log.info("start function save table reservation @Params reqDTO: {}", reqDTO);

            // find currently authenticated user
            String authentication = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<UserEntity> customer = customerRepository.findByEmail(authentication);

            // check customer
            if (!customer.isPresent() || !customer.get().getStatus().equals(UserStatus.ACTIVE)) {
                throw new ApplicationServiceException(200, false, "Customer not found!");
            }

            //check restaurant
            Optional<RestaurantEntity> restaurant = restaurantRepo.findById(reqDTO.getRestaurantId());

            if (!restaurant.isPresent() || !restaurant.get().getStatus().equals(CommonStatus.ACTIVE)) {
                throw new ApplicationServiceException(200, false, "Restaurant not found!");
            }

            TableReservationEntity reservation = TableReservationEntity.builder()
                    .reservationCode("R/" + UUID.randomUUID())
                    .max_count(reqDTO.getSeats())
                    .restaurant(restaurant.get())
                    .customer(customer.get())
                    .reservedDate(reqDTO.getDate())
                    .customerNote(reqDTO.getNote())
                    .tableReservationType(reqDTO.getReservationType())
                    .status(CommonStatus.ACTIVE)
                    .operationalStatus(TableReservationOperationalStatus.NEW)
                    .build();

            TableReservationEntity saved = tableReservationRepo.save(reservation);
            return modelMapper.map(saved, TableReservationResDTO.class);

        } catch (Exception e) {
            log.error("Error while saving table reservation", e);
            throw e;
        }
    }

    @Override
    public OrderPaymentSessionResDTO saveMealOrder(MealOrderReqDTO mealOrderDTO) {
        try {
            log.info("start function save meal order @Params mealOrderDTO: {}", mealOrderDTO);

            // find currently authenticated user
            String authentication = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<UserEntity> customer = customerRepository.findByEmail(authentication);

            // check customer
            if (!customer.isPresent() || !customer.get().getStatus().equals(UserStatus.ACTIVE)) {
                throw new ApplicationServiceException(200, false, "Customer not found!");
            }

            //check restaurant
            Optional<RestaurantEntity> restaurant = restaurantRepo.findById(mealOrderDTO.getAddress().getRestaurantId());

            if (!restaurant.isPresent() || !restaurant.get().getStatus().equals(CommonStatus.ACTIVE)) {
                throw new ApplicationServiceException(200, false, "Restaurant not found!");
            }

            MealOrderEntity mealOrder = MealOrderEntity.builder()
                    .orderId("M/" + UUID.randomUUID())
                    .mealOrderType(MealOrderType.ONLINE)
                    .operationalStatus(MealOperationalStatus.NEW)
                    .userEntity(customer.get())
                    .restaurant(restaurant.get())
                    .status(CommonStatus.ACTIVE)
                    .deliveryAddress(mealOrderDTO.getAddress().getAddress())
                    .fullName(mealOrderDTO.getAddress().getFullName())
                    .mobileNumber(mealOrderDTO.getAddress().getMobileNumber())
                    .paymentStatus(PaymentStatus.NOT_PAID)
                    .build();

            MealOrderEntity savedMealOrder = mealOrderRepo.save(mealOrder);

            AtomicReference<Float> total = new AtomicReference<>((float) 0);

            // create meal order detail
            if (mealOrderDTO.getItems() != null && !mealOrderDTO.getItems().isEmpty()) {

                List<MealOrderDetail> orderDetails = mealOrderDTO.getItems().stream().map(item -> {

                    Optional<MealEntity> meal = mealsRepo.findById(item.getId());

                    if (!meal.isPresent() || !meal.get().getStatus().equals(CommonStatus.ACTIVE)) {
                        throw new ApplicationServiceException(200, false, "Meal not found!");
                    }

                    float price = meal.get().getDiscount() == null ? meal.get().getPrice() : meal.get().getPrice() - meal.get().getDiscount();

                    total.updateAndGet(v -> v + price);

                    return MealOrderDetail.builder()
                            .meal(meal.get())
                            .qty(item.getQty())
                            .price(price)
                            .discount(meal.get().getDiscount())
                            .mealOrder(savedMealOrder)
                            .build();
                }).collect(Collectors.toList());

                // save order details and generate payment session link
                try {
                    mealOrderDetailRepo.saveAll(orderDetails);

                    paymentRepo.save(Payment.builder()
                            .queryType(QueryType.MEAL)
                            .mealOrder(savedMealOrder)
                            .price(total.get())
                            .createdDate(new Date())
                            .updatedDate(new Date())
                            .paymentStatus(PaymentStatus.PENDING)
                            .build());

                    return OrderPaymentSessionResDTO.builder()
                            .orderId(savedMealOrder.getId())
                            .sessionLink(generatePaymentSessionLinkMealOrder(orderDetails))
                            .build();
                } catch (Exception e) {
                    throw new ApplicationServiceException(200, false, "Error while saving order details!");
                }

            } else {
                throw new ApplicationServiceException(200, false, "No items found!");
            }

        } catch (Exception e) {
            log.error("Error while saving table reservation", e);
            throw e;
        }
    }

    @Override
    public Object getReservationsByType(QueryType type, Long id) {
        try {
            log.info("start function getReservationsByType @Params type: {}, id: {}", type, id);

            List<ReservationResDTO<?, ?>> reservationResDTOS = new ArrayList<>();

            switch (type) {
                case MEAL:
                    reservationResDTOS = mealOrderRepo.findByUserEntityId(id).stream().map(mealOrderEntity -> {
                        List<MealOrderDetail> byMealOrderId = mealOrderDetailRepo.findByMealOrderId(mealOrderEntity.getId());

                        AtomicReference<Double> total = new AtomicReference<>((double) 0);

                        List<MealResDTO> items = byMealOrderId.stream().map(mealOrderDetail -> {
                            MealResDTO dto = modelMapper.map(mealOrderDetail.getMeal(), MealResDTO.class);
                            dto.setQty(mealOrderDetail.getQty());
                            total.updateAndGet(v -> v + mealOrderDetail.getPrice() * mealOrderDetail.getQty());
                            return dto;
                        }).collect(Collectors.toList());

                        return ReservationResDTO.<MealReservationResDTO, MealResDTO>builder()
                                .reservation(MealReservationResDTO.builder()
                                        .id(mealOrderEntity.getId())
                                        .total(total.get())
                                        .orderId(mealOrderEntity.getOrderId())
                                        .operationalStatus(mealOrderEntity.getOperationalStatus())
                                        .status(mealOrderEntity.getStatus())
                                        .mealOrderType(mealOrderEntity.getMealOrderType())
                                        .userEntity(mealOrderEntity.getUserEntity().getId())
                                        .restaurant(mealOrderEntity.getRestaurant().getId())
                                        .createdDate(mealOrderEntity.getCreatedDate())
                                        .updatedDate(mealOrderEntity.getUpdatedDate())
                                        .build())
                                .items(items)
                                .queries(queryService.getQueries(QueryType.MEAL, mealOrderEntity.getId()))
                                .build();
                    }).collect(Collectors.toList());
                    break;

                case TABLE:
                    reservationResDTOS = tableReservationRepo.findTableReservationEntityByCustomerId(id).stream().map(tableReservationEntity -> {
                        List<TableReservationDetailEntity> byReservationId = tableReservationDetailRepo.findByReservationId(tableReservationEntity.getId());

                        List<TableResDTO> items = byReservationId.stream().map(tableReservationDetailEntity -> {
                            return modelMapper.map(tableReservationDetailEntity.getTable(), TableResDTO.class);
                        }).collect(Collectors.toList());

                        return ReservationResDTO.<TableReservationResDTO, TableResDTO>builder()
                                .reservation(TableReservationResDTO.builder()
                                        .id(tableReservationEntity.getId())
                                        .reservationCode(tableReservationEntity.getReservationCode())
                                        .max_count(tableReservationEntity.getMax_count())
                                        .reservedDate(tableReservationEntity.getReservedDate())
                                        .status(tableReservationEntity.getStatus())
                                        .approvedBy(tableReservationEntity.getApprovedBy())
                                        .approvedNote(tableReservationEntity.getApprovedNote())
                                        .customerNote(tableReservationEntity.getCustomerNote())
                                        .tableReservationType(tableReservationEntity.getTableReservationType())
                                        .operationalStatus(tableReservationEntity.getOperationalStatus())
                                        .createdDate(tableReservationEntity.getCreatedDate())
                                        .updatedDate(tableReservationEntity.getUpdatedDate())
                                        .build())
                                .items(items)
                                .queries(queryService.getQueries(QueryType.TABLE, tableReservationEntity.getId()))
                                .build();
                    }).collect(Collectors.toList());
                    break;

                case CUSTOM:
                    reservationResDTOS.add(ReservationResDTO.builder()
                            .queries(queryService.getQueries(QueryType.CUSTOM, id))
                            .build());
            }

            return reservationResDTOS;

        } catch (Exception e) {
            log.error("Error while saving table reservation", e);
            throw e;
        }
    }

    @Override
    public Object getReservationsByTypeAndId(QueryType type, Long id) {
        try {
            log.info("start function getReservationsByTypeAndId @Params type: {}, id: {}", type, id);

            List<ReservationResDTO<?, ?>> reservationResDTOS = new ArrayList<>();

            switch (type) {
                case MEAL:
                    reservationResDTOS = mealOrderRepo.findByIdV2(id).stream().map(mealOrderEntity -> {
                        List<MealOrderDetail> byMealOrderId = mealOrderDetailRepo.findByMealOrderId(mealOrderEntity.getId());

                        AtomicReference<Double> total = new AtomicReference<>((double) 0);

                        List<MealResDTO> items = byMealOrderId.stream().map(mealOrderDetail -> {
                            MealResDTO dto = modelMapper.map(mealOrderDetail.getMeal(), MealResDTO.class);
                            dto.setQty(mealOrderDetail.getQty());
                            total.updateAndGet(v -> v + mealOrderDetail.getPrice() * mealOrderDetail.getQty());
                            return dto;
                        }).collect(Collectors.toList());

                        return ReservationResDTO.<MealReservationResDTO, MealResDTO>builder()
                                .reservation(MealReservationResDTO.builder()
                                        .id(mealOrderEntity.getId())
                                        .total(total.get())
                                        .orderId(mealOrderEntity.getOrderId())
                                        .operationalStatus(mealOrderEntity.getOperationalStatus())
                                        .status(mealOrderEntity.getStatus())
                                        .mealOrderType(mealOrderEntity.getMealOrderType())
                                        .userEntity(mealOrderEntity.getUserEntity().getId())
                                        .restaurant(mealOrderEntity.getRestaurant().getId())
                                        .createdDate(mealOrderEntity.getCreatedDate())
                                        .updatedDate(mealOrderEntity.getUpdatedDate())
                                        .build())
                                .items(items)
                                .queries(queryService.getQueries(QueryType.MEAL, mealOrderEntity.getId()))
                                .build();
                    }).collect(Collectors.toList());
                    break;

                case TABLE:
                    reservationResDTOS = tableReservationRepo.findByIdV2(id).stream().map(tableReservationEntity -> {
                        List<TableReservationDetailEntity> byReservationId = tableReservationDetailRepo.findByReservationId(tableReservationEntity.getId());

                        List<TableResDTO> items = byReservationId.stream().map(tableReservationDetailEntity -> {
                            return modelMapper.map(tableReservationDetailEntity.getTable(), TableResDTO.class);
                        }).collect(Collectors.toList());

                        return ReservationResDTO.<TableReservationResDTO, TableResDTO>builder()
                                .reservation(TableReservationResDTO.builder()
                                        .id(tableReservationEntity.getId())
                                        .reservationCode(tableReservationEntity.getReservationCode())
                                        .max_count(tableReservationEntity.getMax_count())
                                        .reservedDate(tableReservationEntity.getReservedDate())
                                        .status(tableReservationEntity.getStatus())
                                        .approvedBy(tableReservationEntity.getApprovedBy())
                                        .approvedNote(tableReservationEntity.getApprovedNote())
                                        .customerNote(tableReservationEntity.getCustomerNote())
                                        .tableReservationType(tableReservationEntity.getTableReservationType())
                                        .operationalStatus(tableReservationEntity.getOperationalStatus())
                                        .createdDate(tableReservationEntity.getCreatedDate())
                                        .updatedDate(tableReservationEntity.getUpdatedDate())
                                        .build())
                                .items(items)
                                .queries(queryService.getQueries(QueryType.TABLE, tableReservationEntity.getId()))
                                .build();
                    }).collect(Collectors.toList());
                    break;

                case CUSTOM:
                    reservationResDTOS.add(ReservationResDTO.builder()
                            .queries(queryService.getQueries(QueryType.CUSTOM, id))
                            .build());
            }

            return reservationResDTOS;

        } catch (Exception e) {
            log.error("Error while saving table reservation", e);
            throw e;
        }
    }

    @Override
    public Object getAllReservations(QueryType type) {
        try {
            log.info("start function getAllReservations @Params type: {}", type);

            List<ReservationResDTO<?, ?>> reservationResDTOS = new ArrayList<>();

            switch (type) {
                case MEAL:
                    reservationResDTOS = mealOrderRepo.findAll().stream().map(mealOrderEntity -> {
                        List<MealOrderDetail> byMealOrderId = mealOrderDetailRepo.findByMealOrderId(mealOrderEntity.getId());

                        AtomicReference<Double> total = new AtomicReference<>((double) 0);

                        List<MealResDTO> items = byMealOrderId.stream().map(mealOrderDetail -> {
                            MealResDTO dto = modelMapper.map(mealOrderDetail.getMeal(), MealResDTO.class);
                            dto.setQty(mealOrderDetail.getQty());
                            total.updateAndGet(v -> v + mealOrderDetail.getPrice() * mealOrderDetail.getQty());
                            return dto;
                        }).collect(Collectors.toList());

                        return ReservationResDTO.<MealReservationResDTO, MealResDTO>builder()
                                .reservation(MealReservationResDTO.builder()
                                        .id(mealOrderEntity.getId())
                                        .total(total.get())
                                        .orderId(mealOrderEntity.getOrderId())
                                        .operationalStatus(mealOrderEntity.getOperationalStatus())
                                        .status(mealOrderEntity.getStatus())
                                        .mealOrderType(mealOrderEntity.getMealOrderType())
                                        .userEntity(mealOrderEntity.getUserEntity().getId())
                                        .restaurant(mealOrderEntity.getRestaurant().getId())
                                        .createdDate(mealOrderEntity.getCreatedDate())
                                        .updatedDate(mealOrderEntity.getUpdatedDate())
                                        .build())
                                .items(items)
                                .queries(queryService.getQueries(QueryType.MEAL, mealOrderEntity.getId()))
                                .build();
                    }).collect(Collectors.toList());
                    break;

                case TABLE:
                    reservationResDTOS = tableReservationRepo.findAll().stream().map(tableReservationEntity -> {
                        List<TableReservationDetailEntity> byReservationId = tableReservationDetailRepo.findByReservationId(tableReservationEntity.getId());

                        List<TableResDTO> items = byReservationId.stream().map(tableReservationDetailEntity -> {
                            return modelMapper.map(tableReservationDetailEntity.getTable(), TableResDTO.class);
                        }).collect(Collectors.toList());

                        return ReservationResDTO.<TableReservationResDTO, TableResDTO>builder()
                                .reservation(TableReservationResDTO.builder()
                                        .id(tableReservationEntity.getId())
                                        .reservationCode(tableReservationEntity.getReservationCode())
                                        .max_count(tableReservationEntity.getMax_count())
                                        .reservedDate(tableReservationEntity.getReservedDate())
                                        .status(tableReservationEntity.getStatus())
                                        .approvedBy(tableReservationEntity.getApprovedBy())
                                        .approvedNote(tableReservationEntity.getApprovedNote())
                                        .customerNote(tableReservationEntity.getCustomerNote())
                                        .tableReservationType(tableReservationEntity.getTableReservationType())
                                        .operationalStatus(tableReservationEntity.getOperationalStatus())
                                        .createdDate(tableReservationEntity.getCreatedDate())
                                        .updatedDate(tableReservationEntity.getUpdatedDate())
                                        .build())
                                .items(items)
                                .queries(queryService.getQueries(QueryType.TABLE, tableReservationEntity.getId()))
                                .build();
                    }).collect(Collectors.toList());
                    break;

                case CUSTOM:
                    reservationResDTOS.add(ReservationResDTO.builder()
                            .queries(queryService.getQueries(QueryType.CUSTOM, 0L))
                            .build());
            }

            return reservationResDTOS;

        } catch (Exception e) {
            log.error("Error while saving table reservation", e);
            throw e;
        }
    }

    @Override
    public void updateReservationOperationalStatus(Long id, ReservationApproveReqDTO reqDTO) {
        try {
            log.info("start function updateReservationOperationalStatus @params id: {}, reqDTO: {}", id, reqDTO);
            switch (reqDTO.getType()) {
                case MEAL:
                    Optional<MealOrderEntity> mealOrderEntity = mealOrderRepo.findById(id);

                    if (!mealOrderEntity.isPresent() || !mealOrderEntity.get().getStatus().equals(CommonStatus.ACTIVE)) {
                        throw new ApplicationServiceException(200, false, "Meal order does not exist");
                    }

                    mealOrderEntity.get().setOperationalStatus(reqDTO.getMStatus());
                    mealOrderEntity.get().setUpdatedDate(new Date());
                    mealOrderRepo.save(mealOrderEntity.get());

                    try {
                        emailService.sendUserMealOrderOperationalStatusChangeEmail(UserDTO.builder()
                                .email(mealOrderEntity.get().getUserEntity().getEmail())
                                .build(), mealOrderEntity.get(), reqDTO.getMStatus());
                    } catch (MessagingException ex) {
                        throw new RuntimeException(ex);
                    }

                    break;

                case TABLE:
                    Optional<TableReservationEntity> tableReservation = tableReservationRepo.findById(id);

                    if (!tableReservation.isPresent() || !tableReservation.get().getStatus().equals(CommonStatus.ACTIVE)) {
                        throw new ApplicationServiceException(200, false, "Meal order does not exist");
                    }

                    tableReservation.get().setOperationalStatus(reqDTO.getTStatus());
                    tableReservation.get().setUpdatedDate(new Date());
                    tableReservation.get().setApprovedNote(reqDTO.getNote());
                    tableReservationRepo.save(tableReservation.get());

                    try {
                        emailService.sendUserTableReservationOperationalStatusChangeEmail(UserDTO.builder()
                                .email(tableReservation.get().getCustomer().getEmail())
                                .build(), tableReservation.get(), reqDTO.getTStatus());
                    } catch (MessagingException ex) {
                        throw new RuntimeException(ex);
                    }

                    break;
            }
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

    @Override
    public String generatePaymentSessionLinkMealOrder(List<MealOrderDetail> mealOrderDetails) throws StripeException {

        String DOMAIN = "http://localhost:3000";

        List<SessionCreateParams.LineItem> lineItems = mealOrderDetails.stream().map(mealOrderDetail -> SessionCreateParams.LineItem.builder()
                .setQuantity(mealOrderDetail.getQty().longValue())
                .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                        .setCurrency("LKR")
                        .setUnitAmount(mealOrderDetail.getPrice().longValue())
                        .setProductData(
                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName(mealOrderDetail.getMeal().getName())
                                        .addImage(mealOrderDetail.getMeal().getImage())
                                        .setDescription(mealOrderDetail.getMeal().getDescription())
                                        .build())
                        .build())
                .build()).collect(Collectors.toList());

        SessionCreateParams createParams = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(DOMAIN + "/success.html")
                .setCancelUrl(DOMAIN + "/canceled.html")
                .addAllLineItem(lineItems)
                .build();

        return Session.create(createParams).getUrl();
    }

    @Override
    public void settleOrderPayment(QueryType type, Long orderId) {

        if (type == QueryType.MEAL) {
            Optional<MealOrderEntity> mealOrderEntity = mealOrderRepo.findById(orderId);

            if (!mealOrderEntity.isPresent()) {
                throw new ApplicationServiceException(400, false, "Meal order does not exist");
            }

            mealOrderEntity.get().getPayment().setPaymentStatus(PaymentStatus.PAID);
            mealOrderRepo.save(mealOrderEntity.get());

        }else{
            Optional<TableReservationEntity> tableReservation = tableReservationRepo.findById(orderId);

            if (!tableReservation.isPresent()) {
                throw new ApplicationServiceException(400, false, "Meal order does not exist");
            }

            tableReservation.get().getPayment().setPaymentStatus(PaymentStatus.PAID);
            tableReservationRepo.save(tableReservation.get());
        }
    }

}
