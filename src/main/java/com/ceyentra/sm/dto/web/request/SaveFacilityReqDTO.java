package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.enums.CommonFunctionalFrequency;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.FacilityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveFacilityReqDTO {
    Long id;
    Long restaurantId;
    String name;
    MultipartFile imgURL;
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
}
