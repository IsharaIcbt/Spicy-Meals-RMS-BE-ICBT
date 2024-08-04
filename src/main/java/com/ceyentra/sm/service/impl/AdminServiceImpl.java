package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.request.SaveAdminReqDTO;
import com.ceyentra.sm.entity.AdminEntity;
import com.ceyentra.sm.entity.RestaurantEntity;
import com.ceyentra.sm.entity.StaffEntity;
import com.ceyentra.sm.entity.UserEntity;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.UserRole;
import com.ceyentra.sm.enums.UserStatus;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.repository.AdminRepo;
import com.ceyentra.sm.repository.RestaurantRepo;
import com.ceyentra.sm.repository.StaffRepo;
import com.ceyentra.sm.repository.UserRepo;
import com.ceyentra.sm.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;
    private final StaffRepo staffRepo;
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;

    @Override
    public void saveAdmin(SaveAdminReqDTO adminReqDTO) {
        log.info("START FUNCTION saveAdmin");
        try {

            Optional<AdminEntity> adminByEmail = adminRepo.findByEmail(adminReqDTO.getEmail());

            if (adminByEmail.isPresent() && !adminByEmail.get().getStatus().equals(CommonStatus.DELETED)) {
                throw new ApplicationServiceException(200, false, "Email is already in use");
            }

            Optional<StaffEntity> staffByEmail = staffRepo.findByEmail(adminReqDTO.getEmail());

            if (staffByEmail.isPresent() && !staffByEmail.get().getStatus().equals(CommonStatus.DELETED)) {
                throw new ApplicationServiceException(200, false, "Email is already in use");
            }

            Optional<UserEntity> userByEmail = userRepo.findByEmail(adminReqDTO.getEmail());

            if (userByEmail.isPresent() && !userByEmail.get().getStatus().equals(UserStatus.DELETED)) {
                throw new ApplicationServiceException(200, false, "Email is already in use");
            }

            switch (adminReqDTO.getRole()) {

                case ADMIN:

                    AdminEntity newAdmin = AdminEntity.builder()
                            .name(adminReqDTO.getName())
                            .email(adminReqDTO.getEmail())
                            .homeAddress(adminReqDTO.getHomeAddress())
                            .nic(adminReqDTO.getNic())
                            .phoneNumber(adminReqDTO.getPhoneNumber())
                            .userRole(UserRole.ADMIN)
                            .status(CommonStatus.ACTIVE)
                            .build();

                    adminRepo.save(newAdmin);

                case STAFF:

                    Optional<RestaurantEntity> restaurantEntity = restaurantRepo.findById(adminReqDTO.getRestaurantId());

                    if (!restaurantEntity.isPresent() || restaurantEntity.get().getStatus().equals(CommonStatus.DELETED)) {
                        throw new ApplicationServiceException(200, false, "Restaurant not found");
                    }

                    StaffEntity newStaff = StaffEntity.builder()
                            .name(adminReqDTO.getName())
                            .employeeId("STAFF_" + UUID.randomUUID() + "_" + new Date())
                            .restaurant(restaurantEntity.get())
                            .email(adminReqDTO.getEmail())
                            .homeAddress(adminReqDTO.getHomeAddress())
                            .nic(adminReqDTO.getNic())
                            .phoneNumber(adminReqDTO.getPhoneNumber())
                            .userRole(UserRole.STAFF)
                            .status(CommonStatus.ACTIVE)
                            .build();

                    staffRepo.save(newStaff);

                default:
                    throw new ApplicationServiceException(200, false, "Invalid role");
            }
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }
}
