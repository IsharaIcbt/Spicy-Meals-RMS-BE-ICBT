package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.request.MealOrderReqDTO;
import com.ceyentra.sm.dto.web.request.TableReservationReqDTO;
import com.ceyentra.sm.dto.web.response.*;
import com.ceyentra.sm.entity.*;
import com.ceyentra.sm.enums.*;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.repository.*;
import com.ceyentra.sm.service.QueryService;
import com.ceyentra.sm.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
    public void saveMealOrder(MealOrderReqDTO mealOrderDTO) {
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
            Optional<RestaurantEntity> restaurant = restaurantRepo.findById(mealOrderDTO.getRestaurantId());

            if (!restaurant.isPresent() || !restaurant.get().getStatus().equals(CommonStatus.ACTIVE)) {
                throw new ApplicationServiceException(200, false, "Restaurant not found!");
            }

            MealOrderEntity mealOrder = MealOrderEntity.builder()
                    .orderId("M/" + UUID.randomUUID())
                    .mealOrderType(mealOrderDTO.getOrderType())
                    .operationalStatus(MealOperationalStatus.NEW)
                    .userEntity(customer.get())
                    .restaurant(restaurant.get())
                    .status(CommonStatus.ACTIVE)
                    .build();

            MealOrderEntity savedMealOrder = mealOrderRepo.save(mealOrder);

            // create meal order detail
            if (mealOrderDTO.getItems() != null && !mealOrderDTO.getItems().isEmpty()) {

                List<MealOrderDetail> orderDetails = mealOrderDTO.getItems().stream().map(item -> {

                    Optional<MealEntity> meal = mealsRepo.findById(item.getId());

                    if (!meal.isPresent() || !meal.get().getStatus().equals(CommonStatus.ACTIVE)) {
                        throw new ApplicationServiceException(200, false, "Meal not found!");
                    }

                    return MealOrderDetail.builder()
                            .meal(meal.get())
                            .qty(item.getQty())
                            .price(meal.get().getPrice())
                            .discount(meal.get().getDiscount())
                            .mealOrder(savedMealOrder)
                            .build();
                }).collect(Collectors.toList());

                mealOrderDetailRepo.saveAll(orderDetails);

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

                        List<MealResDTO> items = byMealOrderId.stream().map(mealOrderDetail -> {
                            MealResDTO dto = modelMapper.map(mealOrderDetail.getMeal(), MealResDTO.class);
                            dto.setQty(mealOrderDetail.getQty());
                            return dto;
                        }).collect(Collectors.toList());

                        return ReservationResDTO.<MealReservationResDTO, MealResDTO>builder()
                                .reservation(MealReservationResDTO.builder()
                                        .id(mealOrderEntity.getId())
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

}
