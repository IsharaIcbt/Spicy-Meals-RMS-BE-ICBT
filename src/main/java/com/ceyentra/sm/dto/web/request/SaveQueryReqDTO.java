package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.entity.*;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.QueryType;
import com.ceyentra.sm.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveQueryReqDTO {
    Long id;
    Long mealOrderId;
    Long tableReservationId;
    UserRole userRole;
    QueryType queryType;
    String message;
    Long userId;
    Long repliedTo;
    CommonStatus status;
}
