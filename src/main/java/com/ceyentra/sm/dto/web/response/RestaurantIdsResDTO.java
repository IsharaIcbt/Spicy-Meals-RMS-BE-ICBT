package com.ceyentra.sm.dto.web.response;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantIdsResDTO {
    private Long value;
    private String label;
}
