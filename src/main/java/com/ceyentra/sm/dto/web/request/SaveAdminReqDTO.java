package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveAdminReqDTO {

    Long id;
    String employeeId;
    String email;
    String homeAddress;
    Long restaurantId;
    String name;
    String nic;
    String password;
    String phoneNumber;
    MultipartFile img;
    UserRole role;
}
