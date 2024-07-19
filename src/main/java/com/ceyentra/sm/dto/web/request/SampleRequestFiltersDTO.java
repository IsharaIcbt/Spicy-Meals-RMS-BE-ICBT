/**
 * @author :  Dinuth Dheeraka
 * Created : 8/8/2023 2:34 AM
 */
package com.ceyentra.sm.dto.web.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SampleRequestFiltersDTO {
    Long start;
    Long end;
    int page;
    int size;
    String number;
    String managerStatus;
    String srEmployeeStatus;
}
