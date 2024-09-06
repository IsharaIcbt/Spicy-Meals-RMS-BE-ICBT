package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.MealOperationalStatus;
import com.ceyentra.sm.enums.MealOrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MealReservationResDTO {

    Long id;
    String orderId;
    MealOperationalStatus operationalStatus;
    CommonStatus status;
    MealOrderType mealOrderType;
    Long userEntity;
    Long restaurant;
    Date createdDate;
    Date updatedDate;
    Double total;
    List<MealResDTO> items;
}
