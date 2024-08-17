package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.dto.web.request.SaveQueryReqDTO;
import com.ceyentra.sm.dto.web.response.QueryResDTO;
import com.ceyentra.sm.entity.*;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.QueryType;
import com.ceyentra.sm.enums.UserStatus;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.repository.*;
import com.ceyentra.sm.service.QueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class QueryServiceImpl implements QueryService {

    private final AdminRepo adminRepo;
    private final StaffRepo staffRepo;
    private final UserRepo userRepo;
    private final MealOrderRepo mealOrderRepo;
    private final TableReservationRepo tableReservationRepo;
    private final QueryRepo queryRepo;

    @Override
    public void save(SaveQueryReqDTO saveQueryReqDTO) {
        try {
            QueryEntity queryEntity = new QueryEntity();

            // set query user
            switch (saveQueryReqDTO.getUserRole()) {
                case ADMIN:
                    Optional<AdminEntity> adminEntity = adminRepo.findAdminEntityByIdAndStatus(saveQueryReqDTO.getUserId(), CommonStatus.ACTIVE);
                    if (!adminEntity.isPresent()) {
                        throw new ApplicationServiceException(200, false, "Admin does not exist");
                    }
                    queryEntity.setAdmin(adminEntity.get());
                    break;

                case STAFF:
                    Optional<StaffEntity> staffEntity = staffRepo.findStaffEntityByIdAndStatus(saveQueryReqDTO.getUserId(), CommonStatus.ACTIVE);
                    if (!staffEntity.isPresent()) {
                        throw new ApplicationServiceException(200, false, "Admin does not exist");
                    }
                    queryEntity.setStaff(staffEntity.get());
                    break;

                case CUSTOMER:
                    Optional<UserEntity> userEntity = userRepo.findUserEntityByIdAndStatus(saveQueryReqDTO.getUserId(), UserStatus.ACTIVE);
                    if (!userEntity.isPresent()) {
                        throw new ApplicationServiceException(200, false, "Admin does not exist");
                    }
                    queryEntity.setUser(userEntity.get());
                    break;

                default:
                    throw new ApplicationServiceException(200, false, "Invalid user role!");
            }

            // set query related order
            switch (saveQueryReqDTO.getQueryType()) {
                case MEAL:
                    Optional<MealOrderEntity> mealOrderEntity = mealOrderRepo.findById(saveQueryReqDTO.getMealOrderId());

                    if (!mealOrderEntity.isPresent()) {
                        throw new ApplicationServiceException(200, false, "Meal order does not exist");
                    }

                    queryEntity.setMealOrder(mealOrderEntity.get());
                    break;

                case TABLE:
                    Optional<TableReservationEntity> tableReservationEntity = tableReservationRepo.findById(saveQueryReqDTO.getTableReservationId());

                    if (!tableReservationEntity.isPresent()) {
                        throw new ApplicationServiceException(200, false, "Meal order does not exist");
                    }

                    queryEntity.setTableReservation(tableReservationEntity.get());
                    break;

                case CUSTOM:
                    Optional<UserEntity> userEntity = userRepo.findById(saveQueryReqDTO.getRepliedTo());

                    if (!userEntity.isPresent()) {
                        throw new ApplicationServiceException(200, false, "Customer does not exist");
                    }

                    queryEntity.setUser(userEntity.get());
                    break;

                default:
                    throw new ApplicationServiceException(200, false, "Invalid query type!");
            }

            queryEntity.setMessage(saveQueryReqDTO.getMessage());
            queryEntity.setQueryType(saveQueryReqDTO.getQueryType());
            queryEntity.setUserRole(saveQueryReqDTO.getUserRole());
            queryEntity.setStatus(CommonStatus.ACTIVE);
            queryRepo.save(queryEntity);

        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

    @Override
    public List<QueryResDTO>  getQueries(QueryType type, Long id) {
        try {
            List<QueryEntity> queryEntities = new ArrayList<>();

            switch (type) {
                case MEAL:
                    Optional<MealOrderEntity> mealOrderEntity = mealOrderRepo.findById(id);

                    if (!mealOrderEntity.isPresent()) {
                        throw new ApplicationServiceException(200, false, "Meal order does not exist");
                    }

                    queryEntities = queryRepo.findAllByMealOrder_IdOrderByCreatedDate(id);
                    break;

                case TABLE:
                    Optional<TableReservationEntity> tableReservationEntity = tableReservationRepo.findById(id);

                    if (!tableReservationEntity.isPresent()) {
                        throw new ApplicationServiceException(200, false, "Meal order does not exist");
                    }

                    queryEntities = queryRepo.findAllByTableReservation_IdOrderByCreatedDate(id);
                    break;

                case CUSTOM:
                    queryEntities = queryRepo.findQueryEntitiesByQueryTypeAndUser_IdOrderByCreatedDate(QueryType.CUSTOM, id);
                    break;
            }

            return queryEntities.stream().map(queryEntity -> QueryResDTO.builder()
                    .id(queryEntity.getId())
                    .mealOrder(queryEntity.getMealOrder().getId())
                    .tableReservation(queryEntity.getTableReservation().getId())
                    .queryType(queryEntity.getQueryType())
                    .message(queryEntity.getMessage())
                    .user(UserDTO.builder()
                            .id(queryEntity.getUser().getId())
                            .name(queryEntity.getUser().getName())
                            .img(queryEntity.getUser().getImg())
                            .build())
                    .admin(UserDTO.builder()
                            .id(queryEntity.getAdmin().getId())
                            .name(queryEntity.getAdmin().getName())
                            .build())
                    .staff(UserDTO.builder()
                            .id(queryEntity.getStaff().getId())
                            .name(queryEntity.getStaff().getName())
                            .build())
                    .userRole(queryEntity.getUserRole())
                    .createdDate(queryEntity.getCreatedDate())
                    .updatedDate(queryEntity.getUpdatedDate())
                    .status(queryEntity.getStatus())
                    .build()).collect(Collectors.toList());

        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }
}
