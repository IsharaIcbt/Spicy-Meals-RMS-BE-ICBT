/**
 * @author :  Dinuth Dheeraka
 * Created : 8/5/2023 1:04 PM
 */
package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.enums.UserRole;
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
    private String name;
    private String email;
    private Date createdDate;
    private UserRole userRole;
}
