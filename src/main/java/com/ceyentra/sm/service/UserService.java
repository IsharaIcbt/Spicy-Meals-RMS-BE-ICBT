package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.dto.web.request.UserSaveReqDTO;
import com.ceyentra.sm.enums.UserStatus;

import java.util.List;

public interface UserService {

    void saveUser(UserSaveReqDTO userDTO);

    List<UserDTO> getAllUsersByStatus(UserStatus status);

    UserDTO getUserByUserId(Long id);

    void updateUserStatus(Long id, UserStatus status);

    void resetUserPassword(String email);

    void resetUserPassword(Long id, String password,boolean isSendEmail);

    void resetUserPassword(String email, int OTP, String password);

    UserDTO findUserByEmail(String email);

    void sendUserOTP(String email);
}
