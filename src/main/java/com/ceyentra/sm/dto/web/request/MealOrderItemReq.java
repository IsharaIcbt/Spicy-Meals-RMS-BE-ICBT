package com.ceyentra.sm.dto.web.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MealOrderItemReq {
    Long id;
    Float qty;
}
