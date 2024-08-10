/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 8:50 PM
 */
package com.ceyentra.sm.dto;

import com.ceyentra.sm.enums.UserRole;
import com.ceyentra.sm.enums.UserStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class UserDTO {

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


