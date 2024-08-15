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
    String restaurantName;
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

    public FacilityCommonResDTO(Long id, Long restaurantId, String name, String imgURL, String description, CommonFunctionalFrequency frequency, Date reservedDate, String start, String close, String weekDays, Integer maxParticipantCount, Float price, Float discount, FacilityType facilityType, CommonStatus availability, Date createdDate, Date updatedDate) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.name = name;
        this.imgURL = imgURL;
        this.description = description;
        this.frequency = frequency;
        this.reservedDate = reservedDate;
        this.start = start;
        this.close = close;
        this.weekDays = weekDays;
        this.maxParticipantCount = maxParticipantCount;
        this.price = price;
        this.discount = discount;
        this.facilityType = facilityType;
        this.availability = availability;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
