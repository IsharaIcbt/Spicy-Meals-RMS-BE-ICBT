package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.enums.UserRole;
import com.ceyentra.sm.enums.UserStatus;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class UserSaveReqDTO {
    private Long id;
    private MultipartFile imgFile;
    private String name;
    private String email;
    private String password;
    private String nic;
    private String phoneNumber;
    private String homeAddress;
    private UserRole userRole;
    private Date createdDate;
    private Date updatedDate;
    UserStatus status;
}
