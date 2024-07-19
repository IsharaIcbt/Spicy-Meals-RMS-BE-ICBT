/**
 * @author :  Dinuth Dheeraka
 * Created : 8/6/2023 12:24 AM
 */
package com.ceyentra.sm.dto.web.request;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SampleRequestRequestDTO {

    String lotNumber;
    String saleNumber;
    String buyerComment;
}
