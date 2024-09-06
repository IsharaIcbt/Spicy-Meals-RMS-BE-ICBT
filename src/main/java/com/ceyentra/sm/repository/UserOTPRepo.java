package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.UserOTPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserOTPRepo extends JpaRepository<UserOTPEntity, Long> {

    @Modifying
    @Query(value = "INSERT INTO user_otp (user_id,otp,created_date) VALUES (?1,?2,?3)", nativeQuery = true)
    void saveUserOTP(Long userId, int OTP, String createdDate);

    Optional<UserOTPEntity> findByOtp(int otp);

    @Query(value = "SELECT * FROM user_otp  u WHERE u.user_id=?1 && u.otp=?2", nativeQuery = true)
    Optional<UserOTPEntity> findOTPWithUserId(Long userId,int OTP);
}
