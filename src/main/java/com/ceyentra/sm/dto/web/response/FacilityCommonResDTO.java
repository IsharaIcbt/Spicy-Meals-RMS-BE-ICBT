package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacilityCommonResDTO {
    Long id;
    Long restaurantId;
    String name;
    String imgURL;
    String description;
    CommonFunctionalFrequency frequency;
    Date reservedDate;
    String start;
    String close;
    String weekDays;
    Integer maxParticipantCount;
    Float price;
    Float discount;
    FacilityType facilityType;
    CommonStatus availability;
    Date createdDate;
    Date updatedDate;
}
