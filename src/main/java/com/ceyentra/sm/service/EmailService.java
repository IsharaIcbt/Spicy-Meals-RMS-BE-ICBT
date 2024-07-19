package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.SampleRequestDTO;
import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.enums.UserRole;

import javax.mail.MessagingException;
import java.util.List;

public interface EmailService {

    void sendUserAccountCredentialsEmail(UserDTO userDTO) throws MessagingException;

    void sendUserOTPEmail(UserDTO userDTO, int OTP) throws MessagingException;

    void sendUserNewPasswordEmail(UserDTO userDTO) throws MessagingException;

    void sendBuyerSampleRequestAcceptedEmail(UserDTO userDTO, SampleRequestDTO sampleRequestDTO) throws MessagingException;

    void sendBuyerSampleRequestDeclinedEmail(UserDTO userDTO, SampleRequestDTO sampleRequestDTO) throws MessagingException;

    void sendSampleRequestToManagersOrSREmployees(List<String> emails,
                                                  SampleRequestDTO sampleRequestDTO,
                                                  UserRole userRole) throws MessagingException;

    void sendSampleEmail() throws MessagingException;
}
