package com.ceyentra.sm.dto.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MealOrderAddress {
    String address;
    String fullName;
    String mobileNumber;
    Long restaurantId;
}
