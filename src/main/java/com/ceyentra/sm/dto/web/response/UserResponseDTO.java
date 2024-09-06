/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 1:04 PM
 */
package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.enums.UserRole;
import com.ceyentra.sm.enums.UserStatus;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String img;
    private String name;
    private String email;
    private String password;
    private String nic;
    private String phoneNumber;
    private String homeAddress;
    private UserRole userRole;
    private Date createdDate;
    private UserStatus userStatus;
}
