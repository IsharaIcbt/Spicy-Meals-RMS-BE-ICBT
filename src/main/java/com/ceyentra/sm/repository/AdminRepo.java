package com.ceyentra.sm.repository;

import com.ceyentra.sm.dto.web.response.AdminStaffCommonResDTO;
import com.ceyentra.sm.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findByEmail(String email);

    @Query(value = "SELECT new com.ceyentra.sm.dto.web.response.AdminStaffCommonResDTO(ae.id,ae.name,ae.email,ae.nic,ae.phoneNumber,ae.tempPassword,ae.homeAddress,ae.status,ae.userRole,ae.createdDate,ae.updatedDate) FROM AdminEntity ae")
    List<AdminStaffCommonResDTO> findAllAdminStaffCommonResDTO();
}