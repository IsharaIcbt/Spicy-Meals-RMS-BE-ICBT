package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.entity.RestaurantEntity;
import com.ceyentra.sm.entity.UserEntity;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.TableReservationOperationalStatus;
import com.ceyentra.sm.enums.TableReservationType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableReservationResDTO {

    Long id;
    String reservationCode;
    Integer max_count;
    Date reservedDate;
    CommonStatus status;
    Long approvedBy;
    String approvedNote;
    String customerNote;
    TableReservationType tableReservationType;
    TableReservationOperationalStatus operationalStatus;
    Date createdDate;
    Date updatedDate;
}
