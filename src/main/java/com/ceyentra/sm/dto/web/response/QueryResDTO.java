package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.dto.UserDTO;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.QueryType;
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
public class QueryResDTO {
    Long id;
    Long mealOrder;
    Long tableReservation;
    QueryType queryType;
    String message;
    UserDTO user;
    UserDTO admin;
    UserDTO staff;
    UserRole userRole;
    Date createdDate;
    Date updatedDate;
    CommonStatus status;
}
