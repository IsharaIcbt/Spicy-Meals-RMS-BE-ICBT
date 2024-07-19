/**
 * @author :  Dinuth Dheeraka
 * Created : 8/6/2023 1:14 PM
 */
package com.ceyentra.sm.dto.web.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleRequestResponseUserDTO {

    private Long id;
    private String name;
    private String email;
    private String comment;
    private String operationalStatus;
    private String reviewedDate;
}
