package com.ceyentra.sm.dto.web.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class MealsFilterResDTO {

    Long restaurantId;
    List<MealResDTO> meals = new ArrayList<>();
}
