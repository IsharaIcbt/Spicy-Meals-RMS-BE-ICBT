/**
 * @author :  Dinuth Dheeraka
 * Created : 8/7/2023 3:32 PM
 */
package com.ceyentra.sm.dto.web.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserPasswordResetRequestDTO {
    String password;
    int otp;
    String email;
}
