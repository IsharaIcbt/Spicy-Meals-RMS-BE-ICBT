/**
 * @author :  Dinuth Dheeraka
 * Created : 8/11/2023 11:36 AM
 */
package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.constant.EmailTemplateConstant;
import com.ceyentra.sm.dto.SampleRequestDTO;
import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.enums.UserRole;
import com.ceyentra.sm.service.EmailService;
import com.ceyentra.sm.util.EmailSender;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.List;

@Service
@Transactional
@Log4j2
public class EmailServiceImpl implements EmailService {

    private final EmailSender emailSender;
    private final EmailTemplateConstant emailTemplateConstant;

    @Autowired
    public EmailServiceImpl(EmailSender emailSender, EmailTemplateConstant emailTemplateConstant) {
        this.emailSender = emailSender;
        this.emailTemplateConstant = emailTemplateConstant;
    }

    //done
    @Override
    public void sendUserAccountCredentialsEmail(UserDTO userDTO) throws MessagingException {
        log.info("start function sendUserAccountDetailsEmail @Param userDTO : {}", userDTO);
        try {

            //send user new account credentials
            emailSender.sendSimpleEmail(userDTO.getEmail(),
                    EmailTemplateConstant.NEW_USER_ACCOUNT_CREDENTIAL_EMAIL_SUBJECT,
                    emailTemplateConstant.sendUserAccountDetailsTemplate(userDTO));

        } catch (Exception e) {
            log.error("function sendUserAccountDetailsEmail {}", e.getMessage(), e);
            throw e;
        }
    }

    //done
    @Override
    public void sendUserOTPEmail(UserDTO userDTO, int OTP) throws MessagingException {
        log.info("start sendUserOTP @Param OTP : {}", OTP);
        try {

            //sending email that contains OTP
            emailSender.sendSimpleEmail(userDTO.getEmail(),
                    EmailTemplateConstant.SEND_USER_PASSWORD_RESET_OTP_EMAIL_SUBJECT,
                    emailTemplateConstant.sendUserOTPTemplate(OTP));

        } catch (Exception e) {
            log.error("function sendUserOTP {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void sendUserNewPasswordEmail(UserDTO userDTO) throws MessagingException {
        log.info("start sendUserNewPasswordEmail @Param userDTO : {}", userDTO);
        try {

            //sending email that contains OTP
            emailSender.sendSimpleEmail(userDTO.getEmail(),
                    EmailTemplateConstant.SEND_USER_RESET_PASSWORD_EMAIL_SUBJECT,
                    emailTemplateConstant.sendUserNewPasswordTemplate(userDTO.getPassword()));

        } catch (Exception e) {
            log.error("function sendUserOTP {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void sendBuyerSampleRequestAcceptedEmail(UserDTO userDTO, SampleRequestDTO sampleRequestDTO) throws MessagingException {
        log.info("start sendBuyerSampleRequestAcceptedEmail @Param userDTO : {}", userDTO);
        try {

            //sending buyer
            emailSender.sendSimpleEmail(userDTO.getEmail(),
                    EmailTemplateConstant.SEND_BUYER_SAMPLE_REQUEST_ACCEPTED_EMAIL_SUBJECT + sampleRequestDTO.getId(),
                    emailTemplateConstant.sendBuyerSampleRequestAcceptedTemplate(userDTO, sampleRequestDTO));

        } catch (Exception e) {
            log.error("function sendBuyerSampleRequestAcceptedEmail {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void sendBuyerSampleRequestDeclinedEmail(UserDTO userDTO, SampleRequestDTO sampleRequestDTO) throws MessagingException {
        log.info("start sendBuyerSampleRequestDeclinedEmail @Param userDTO : {}", userDTO);
        try {

            //sending buyer
            emailSender.sendSimpleEmail(userDTO.getEmail(),
                    EmailTemplateConstant.SEND_BUYER_SAMPLE_REQUEST__DECLINED_EMAIL_SUBJECT + sampleRequestDTO.getId(),
                    emailTemplateConstant.sendBuyerSampleRequestDeclinedTemplate(userDTO, sampleRequestDTO));

        } catch (Exception e) {
            log.error("function sendBuyerSampleRequestDeclinedEmail {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void sendSampleRequestToManagersOrSREmployees(List<String> emails, SampleRequestDTO sampleRequestDTO, UserRole userRole) throws MessagingException {
        try {
            switch (userRole) {
                case MANAGER:
                    for (String email : emails) {
                        emailSender.sendSimpleEmail(email,
                                EmailTemplateConstant.SEND_NEW_SAMPLE_REQUEST_EMAIL_SUBJECT + sampleRequestDTO.getId(),
                                emailTemplateConstant.sendSampleRequestToManagerTemplate(sampleRequestDTO));
                    }
                    break;

                case SAMPLE_ROOM_EMPLOYEE:
                    for (String email : emails) {
                        emailSender.sendSimpleEmail(email,
                                EmailTemplateConstant.SEND_NEW_SAMPLE_REQUEST_EMAIL_SUBJECT + sampleRequestDTO.getId(),
                                emailTemplateConstant.sendSampleRequestToSREmployeeTemplate(sampleRequestDTO));
                    }
                    break;
            }
        } catch (Exception e) {
            log.info("function sendSampleRequestToManagersAndSREEmployees {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void sendSampleEmail() throws MessagingException {
        log.info("start function sendSampleEmail");
        try {

            //sending email for new account credentials
//            emailSender.sendSimpleEmail("dinuthdheeraka345@gmail.com", "",
//                    emailTemplateConstant.sendBuyerSampleRequestAcceptedTemplate());

        } catch (Exception e) {
            log.error("function sendSampleEmail {}", e.getMessage(), e);
            throw e;
        }
    }
}
