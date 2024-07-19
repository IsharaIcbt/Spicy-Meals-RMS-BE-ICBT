/**
 * @author :  Dinuth Dheeraka
 * Created : 8/6/2023 1:07 PM
 */
package com.ceyentra.sm.dto.web.response;


import com.ceyentra.sm.enums.SampleRequestStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class SampleRequestResponseDTO {

    Long id;
    Long buyerId;
    String buyerName;
    String lotNumber;
    String saleNumber;
    String buyerComment;
    String requestedDate;
    SampleRequestResponseUserDTO manager;
    SampleRequestResponseUserDTO sampleRoomEmployee;
    SampleRequestStatus status;
}
