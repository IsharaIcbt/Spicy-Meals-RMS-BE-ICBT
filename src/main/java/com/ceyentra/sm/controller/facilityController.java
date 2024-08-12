package com.ceyentra.sm.controller;

import com.ceyentra.sm.config.throttling_config.Throttling;
import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.common.ResponseDTO;
import com.ceyentra.sm.dto.web.request.SaveFacilityReqDTO;
import com.ceyentra.sm.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> registerFacility(@RequestBody SaveFacilityReqDTO saveFacilityReqDTO) {
        facilityService.saveFacility(saveFacilityReqDTO);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("Facility successfully registered.")
                        .build()
                , HttpStatus.OK
        );
    }

}
