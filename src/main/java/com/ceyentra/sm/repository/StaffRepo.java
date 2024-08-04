package com.ceyentra.sm.repository;

import com.ceyentra.sm.dto.web.response.AdminStaffCommonResDTO;
import com.ceyentra.sm.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepo extends JpaRepository<StaffEntity, Long> {
    Optional<StaffEntity> findByEmail(String email);

    @Query(value = "SELECT new com.ceyentra.sm.dto.web.response.AdminStaffCommonResDTO(se.id,se.name,se.employeeId,se.email,se.nic,se.phoneNumber,se.homeAddress,se.restaurant.id,se.status,se.userRole,se.createdDate,se.updatedDate) FROM StaffEntity se")
    List<AdminStaffCommonResDTO> findAllAdminStaffCommonResDTO();
}
