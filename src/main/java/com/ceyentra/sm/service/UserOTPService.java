package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.UserOTPDTO;

public interface UserOTPService {

    void addUserOTP(UserOTPDTO userOTPDTO);

    void validateUserOTP(String userEmail,int OTP);
}
