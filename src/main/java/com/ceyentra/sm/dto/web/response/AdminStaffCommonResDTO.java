package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminStaffCommonResDTO {

    Long id;
    String name;
    String employeeId;
    String email;
    String nic;
    String phoneNumber;
    String homeAddress;
    Long restaurantId;
    CommonStatus status;
    UserRole userRole;
    Date createdDate;
    Date updatedDate;

    public AdminStaffCommonResDTO(Long id, String name, String employeeId, String email, String nic, String phoneNumber, String homeAddress, Long restaurantId, CommonStatus status, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
        this.email = email;
        this.nic = nic;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.restaurantId = restaurantId;
        this.status = status;
        this.userRole = userRole;
    }

    public AdminStaffCommonResDTO(Long id, String name, String email, String nic, String phoneNumber, String homeAddress, CommonStatus status, UserRole userRole, Date createdDate, Date updatedDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nic = nic;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.status = status;
        this.userRole = userRole;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
