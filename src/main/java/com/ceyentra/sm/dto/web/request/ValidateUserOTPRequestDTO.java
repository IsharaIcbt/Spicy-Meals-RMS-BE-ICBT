/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 1:29 PM
 */
package com.ceyentra.sm.dto.web.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class ValidateUserOTPRequestDTO {
    private int otp;
    private String email;
}
