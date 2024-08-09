package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.request.SaveAdminReqDTO;
import com.ceyentra.sm.dto.web.response.AdminStaffCommonResDTO;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;
    private final StaffRepo staffRepo;
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveAdmin(SaveAdminReqDTO adminReqDTO) {
        log.info("START FUNCTION saveAdmin");
        try {
            if (adminReqDTO.getId() == 0) { // Save logic

                // Check for unique email across Admin, Staff, and User entities
                validateUniqueEmail(adminReqDTO.getEmail());

                switch (adminReqDTO.getRole()) {
                    case ADMIN:
                        AdminEntity newAdmin = AdminEntity.builder()
                                .name(adminReqDTO.getName())
                                .email(adminReqDTO.getEmail())
                                .homeAddress(adminReqDTO.getHomeAddress())
                                .nic(adminReqDTO.getNic())
                                .phoneNumber(adminReqDTO.getPhoneNumber())
                                .password(bCryptPasswordEncoder.encode(adminReqDTO.getPassword()))
                                .tempPassword(adminReqDTO.getPassword())
                                .userRole(UserRole.ADMIN)
                                .status(adminReqDTO.getStatus())
                                .build();

                        adminRepo.save(newAdmin);
                        break;

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
                                .password(bCryptPasswordEncoder.encode(adminReqDTO.getPassword()))
                                .tempPassword(adminReqDTO.getPassword())
                                .userRole(UserRole.STAFF)
                                .status(adminReqDTO.getStatus())
                                .build();

                        staffRepo.save(newStaff);
                        break;

                    default:
                        throw new ApplicationServiceException(200, false, "Invalid role");
                }

            } else { // Update logic
                switch (adminReqDTO.getRole()) {
                    case ADMIN:
                        AdminEntity existingAdmin = adminRepo.findById(adminReqDTO.getId())
                                .orElseThrow(() -> new ApplicationServiceException(200, false, "Cannot find Related User Account"));

                        existingAdmin.setName(adminReqDTO.getName());
                        existingAdmin.setHomeAddress(adminReqDTO.getHomeAddress());
                        existingAdmin.setNic(adminReqDTO.getNic());
                        existingAdmin.setPhoneNumber(adminReqDTO.getPhoneNumber());
                        existingAdmin.setPassword(bCryptPasswordEncoder.encode(adminReqDTO.getPassword()));
                        existingAdmin.setTempPassword(adminReqDTO.getPassword());
                        existingAdmin.setStatus(adminReqDTO.getStatus());

                        adminRepo.save(existingAdmin);
                        break;

                    case STAFF:
                        StaffEntity existingStaff = staffRepo.findById(adminReqDTO.getId())
                                .orElseThrow(() -> new ApplicationServiceException(200, false, "Cannot find Related User Account"));

                        Optional<RestaurantEntity> restaurantEntity = restaurantRepo.findById(adminReqDTO.getRestaurantId());
                        if (!restaurantEntity.isPresent() || restaurantEntity.get().getStatus().equals(CommonStatus.DELETED)) {
                            throw new ApplicationServiceException(200, false, "Restaurant not found");
                        }

                        existingStaff.setName(adminReqDTO.getName());
                        existingStaff.setHomeAddress(adminReqDTO.getHomeAddress());
                        existingStaff.setNic(adminReqDTO.getNic());
                        existingStaff.setPhoneNumber(adminReqDTO.getPhoneNumber());
                        existingStaff.setPassword(bCryptPasswordEncoder.encode(adminReqDTO.getPassword()));
                        existingStaff.setTempPassword(adminReqDTO.getPassword());
                        existingStaff.setRestaurant(restaurantEntity.get());
                        existingStaff.setStatus(adminReqDTO.getStatus());

                        staffRepo.save(existingStaff);
                        break;

                    default:
                        throw new ApplicationServiceException(200, false, "Invalid role");
                }
            }
        } catch (Exception e) {
            log.error("==>" + e);
            throw e;
        }
    }

    private void validateUniqueEmail(String email) {
        if (adminRepo.findByEmail(email).isPresent() || staffRepo.findByEmail(email).isPresent() || userRepo.findByEmail(email).isPresent()) {
            throw new ApplicationServiceException(200, false, "Email is already in use");
        }
    }



    @Override
    public List<Object> getAllAdminPortalUsers() {
        log.info("START FUNCTION getAllAdminPortalUsers");
        try {
            List<AdminStaffCommonResDTO> staffCommonResDTOS = staffRepo.findAllAdminStaffCommonResDTO();
            List<AdminStaffCommonResDTO> adminCommonResDTOS = adminRepo.findAllAdminStaffCommonResDTO();

            List<Object> allPortalUsers = new ArrayList<>();
            allPortalUsers.addAll(staffCommonResDTOS);
            allPortalUsers.addAll(adminCommonResDTOS);

            return allPortalUsers;
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

    @Override
    public Object findOneAdminPortalUser(String email) {
        log.info("START FUNCTION findOneAdminPortalUser");
        try {
            Optional<AdminEntity> admin = adminRepo.findByEmail(email);
            if (admin.isPresent()) {
                return mapToAdminStaffCommonResDTO(admin.get());
            }

            Optional<StaffEntity> staff = staffRepo.findByEmail(email);
            if (staff.isPresent()) {
                return mapToAdminStaffCommonResDTO(staff.get());
            }

            throw new ApplicationServiceException(404, false, "User not found");
        } catch (Exception e) {
            log.error("Error in findOneAdminPortalUser: ", e);
            throw e;
        }
    }

    private AdminStaffCommonResDTO mapToAdminStaffCommonResDTO(AdminEntity admin) {
        return AdminStaffCommonResDTO.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .nic(admin.getNic())
                .phoneNumber(admin.getPhoneNumber())
                .tempPassword(admin.getTempPassword())
                .homeAddress(admin.getHomeAddress())
                .status(admin.getStatus())
                .userRole(admin.getUserRole())
                .createdDate(admin.getCreatedDate())
                .updatedDate(admin.getUpdatedDate())
                .build();
    }

    private AdminStaffCommonResDTO mapToAdminStaffCommonResDTO(StaffEntity staff) {
        return AdminStaffCommonResDTO.builder()
                .id(staff.getId())
                .employeeId(staff.getEmployeeId())
                .name(staff.getName())
                .email(staff.getEmail())
                .nic(staff.getNic())
                .phoneNumber(staff.getPhoneNumber())
                .tempPassword(staff.getTempPassword())
                .restaurantId(staff.getRestaurant().getId())
                .homeAddress(staff.getHomeAddress())
                .status(staff.getStatus())
                .userRole(staff.getUserRole())
                .createdDate(staff.getCreatedDate())
                .updatedDate(staff.getUpdatedDate())
                .build();
    }
}
