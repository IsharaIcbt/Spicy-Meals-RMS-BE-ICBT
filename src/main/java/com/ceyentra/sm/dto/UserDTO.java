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
    private String name;
    private String password;
    private String email;
    private Date createdDate;
    private UserRole userRole;
    private UserStatus userStatus;
}
