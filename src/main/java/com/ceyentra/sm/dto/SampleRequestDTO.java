/**
 * @author :  Dinuth Dheeraka
 * Created : 8/6/2023 12:23 AM
 */
package com.ceyentra.sm.dto;

import com.ceyentra.sm.enums.ManagerOperationalStatus;
import com.ceyentra.sm.enums.SampleRequestStatus;
import com.ceyentra.sm.enums.SampleRoomEmployeeOperationalStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class SampleRequestDTO {

    Long id;
    UserDTO buyer;
    UserDTO manager;
    UserDTO sampleRoomEmployee;
    String lotNumber;
    String saleNumber;
    String buyerComment;
    Date requestedDate;
    Date managerReviewedDate;
    Date sampleRoomEmployeeReviewedDate;
    String managerComment;
    String sampleRoomEmployeeComment;
    ManagerOperationalStatus managerOperationalStatus;
    SampleRoomEmployeeOperationalStatus sampleRoomEmployeeOperationalStatus;
    SampleRequestStatus status;
}
