package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.entity.MealOrderEntity;
import com.ceyentra.sm.entity.TableReservationEntity;
import com.ceyentra.sm.enums.MealOperationalStatus;
import com.ceyentra.sm.enums.TableReservationOperationalStatus;

import javax.mail.MessagingException;

public interface EmailService {

    void sendUserOTPEmail(UserDTO userDTO, int OTP) throws MessagingException;

    void sendUserNewPasswordEmail(UserDTO userDTO) throws MessagingException;

    void sendUserMealOrderOperationalStatusChangeEmail(UserDTO userDTO, MealOrderEntity mealOrderEntity, MealOperationalStatus mealOperationalStatus) throws MessagingException;

    void sendUserTableReservationOperationalStatusChangeEmail(UserDTO userDTO, TableReservationEntity entity, TableReservationOperationalStatus status) throws MessagingException;
}
