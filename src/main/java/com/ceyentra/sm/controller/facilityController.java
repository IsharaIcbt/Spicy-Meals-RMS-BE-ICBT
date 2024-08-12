package com.ceyentra.sm.controller;


import com.ceyentra.sm.dto.common.ResponseDTO;
import com.ceyentra.sm.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
