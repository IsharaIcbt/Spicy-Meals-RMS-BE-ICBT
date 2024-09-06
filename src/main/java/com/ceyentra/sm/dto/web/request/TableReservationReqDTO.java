package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.enums.TableReservationType;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TableReservationReqDTO {

    Long restaurantId;
    String name;
    String email;
    String phone;
    Date date;
    TableReservationType reservationType;
    int seats;
    String note;
}
