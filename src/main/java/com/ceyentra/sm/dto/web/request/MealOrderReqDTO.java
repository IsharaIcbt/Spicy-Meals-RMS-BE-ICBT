package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.enums.MealOrderType;
import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MealOrderReqDTO {
    Long restaurantId;
    boolean isDiffAddress;
    MealOrderType orderType;
    ArrayList<MealOrderItemReq> items = new ArrayList<>();
}
