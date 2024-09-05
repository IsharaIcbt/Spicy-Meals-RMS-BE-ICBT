package com.ceyentra.sm.dto.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderPaymentSessionResDTO {

    Long orderId;
    String sessionLink;
}
