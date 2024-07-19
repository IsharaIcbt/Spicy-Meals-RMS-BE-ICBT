/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 11:48 AM
 */
package com.ceyentra.sm.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOTPDTO {

    Long id;
    UserDTO userDTO;
    Integer OTP;
    Date createdDate;
}
