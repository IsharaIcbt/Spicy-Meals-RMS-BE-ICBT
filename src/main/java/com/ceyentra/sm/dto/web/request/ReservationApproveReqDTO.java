package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.enums.MealOperationalStatus;
import com.ceyentra.sm.enums.QueryType;
import com.ceyentra.sm.enums.TableReservationOperationalStatus;
import com.ceyentra.sm.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationApproveReqDTO {
    QueryType type;
    MealOperationalStatus mStatus;
    TableReservationOperationalStatus tStatus;
    String note;
    Long userId;
    UserRole userRole;
}
