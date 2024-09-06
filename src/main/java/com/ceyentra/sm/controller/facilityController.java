package com.ceyentra.sm.controller;

import com.ceyentra.sm.config.throttling_config.Throttling;
import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.common.ResponseDTO;
import com.ceyentra.sm.dto.web.request.SaveFacilityReqDTO;
import com.ceyentra.sm.enums.CommonFunctionalFrequency;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.FacilityType;
import com.ceyentra.sm.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/facility")
@RequiredArgsConstructor
public class facilityController {

    private final FacilityService facilityService;

    @GetMapping
    public ResponseEntity<ResponseDTO<Object>>  findAllFacilities() {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .success(true)
                        .data(facilityService.findAllFacilities())
                        .build()
                , HttpStatus.OK
        );
    }

    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<Object>> findFacilityById(@PathVariable Long id) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .success(true)
                        .data(facilityService.findFacilityById(id))
                        .build()
                , HttpStatus.OK
        );
    }

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> registerFacility(
            @RequestParam("id") Long id,
            @RequestParam("restaurantId") Long restaurantId,
            @RequestParam("name") String name,
            @RequestParam(value = "imgURL" , required = false) MultipartFile imgURL,
            @RequestParam("description") String description,
            @RequestParam("frequency") CommonFunctionalFrequency frequency,
            @RequestParam("reservedDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date reservedDate,
            @RequestParam("start") String start,
            @RequestParam("close") String close,
            @RequestParam("weekDays") String weekDays,
            @RequestParam("maxParticipantCount") Integer maxParticipantCount,
            @RequestParam("price") Float price,
            @RequestParam("discount") Float discount,
            @RequestParam("facilityType") FacilityType facilityType,
            @RequestParam("availability") CommonStatus availability
    ) {
        // Your logic here
        SaveFacilityReqDTO saveFacilityReqDTO = SaveFacilityReqDTO.builder()
                .id(id).restaurantId(restaurantId)
                .name(name)
                .imgURL(imgURL)
                .description(description)
                .frequency(frequency)
                .reservedDate(reservedDate)
                .start(start)
                .close(close)
                .weekDays(weekDays)
                .maxParticipantCount(maxParticipantCount)
                .price(price)
                .discount(discount)
                .facilityType(facilityType)
                .availability(availability)
                .build();

        facilityService.saveFacility(saveFacilityReqDTO);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("Facility successfully registered.")
                        .build(),
                HttpStatus.OK
        );
    }


}
