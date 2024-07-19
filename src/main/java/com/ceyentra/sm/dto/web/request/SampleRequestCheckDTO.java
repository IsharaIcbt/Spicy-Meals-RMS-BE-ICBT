/**
 * @author :  Dinuth Dheeraka
 * Created : 8/6/2023 4:54 PM
 */
package com.ceyentra.sm.dto.web.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SampleRequestCheckDTO {

    private Long sampleRequestId;
    private String comment;
    private String operationalStatus;
}
