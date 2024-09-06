/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 11:52 AM
 */
package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.constant.ApplicationConstant;
import com.ceyentra.sm.dto.UserOTPDTO;
import com.ceyentra.sm.entity.EmailPasswordResetOTPEntity;
import com.ceyentra.sm.exception.UserOTPException;
import com.ceyentra.sm.repository.EmailPasswordResetOTPRepo;
import com.ceyentra.sm.repository.UserOTPRepo;
import com.ceyentra.sm.repository.UserRepo;
import com.ceyentra.sm.service.UserOTPService;
import com.ceyentra.sm.util.CustomDateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class UserOTPServiceImpl implements UserOTPService {

    private final UserOTPRepo userOTPRepository;
    private final UserRepo userRepository;
    private final CustomDateUtil customDateUtil;
    private final EmailPasswordResetOTPRepo emailPasswordResetOTPRepo;

    @Override
    public void addUserOTP(UserOTPDTO userOTPDTO) {
        log.info("start function addUserOTP @Param userOTPDTO : {}", userOTPDTO);
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            userOTPRepository.saveUserOTP(userOTPDTO.getUserDTO().getId(), userOTPDTO.getOTP(),
                    dateFormat.format(new Date()));

        } catch (Exception e) {
            log.error("function addUerOTP {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void validateUserOTP(String userEmail, int OTP) {
        log.info("start function validateUserOTP @Param userEmail : {} @Param OTP : {}", userEmail, OTP);
        try {
            Optional<EmailPasswordResetOTPEntity> byEmailAndOtp = emailPasswordResetOTPRepo.findEmailPasswordResetOTPEntitiesByEmailAndOtp(userEmail, String.valueOf(OTP));

            if (!byEmailAndOtp.isPresent())
                throw new UserOTPException(ApplicationConstant.INVALID_OTP, false, "The OTP you entered is invalid. Please double-check the OTP and try again.");

            //check OTP if expired
            if (customDateUtil.calculateDifferentIneMinutes(new Date(System.currentTimeMillis()), byEmailAndOtp.get().getCreatedDate()) >= 10)
                throw new UserOTPException(ApplicationConstant.OTP_TIME_OUT, false, "Your OTP has expired. Please request a new OTP to continue with your verification.");

        } catch (Exception e) {
            log.error("function validateUserOTP {}", e.getMessage(), e);
            throw e;
        }
    }
}
