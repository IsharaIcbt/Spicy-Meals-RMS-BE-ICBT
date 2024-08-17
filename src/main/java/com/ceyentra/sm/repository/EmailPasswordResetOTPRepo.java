package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.EmailPasswordResetOTPEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailPasswordResetOTPRepo extends JpaRepository<EmailPasswordResetOTPEntity, Long> {

    List<EmailPasswordResetOTPEntity> findEmailPasswordResetOTPEntitiesByEmail(String email);
}
