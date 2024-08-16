package com.ceyentra.sm.controller;

import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.web.request.MealOrderReqDTO;
import com.ceyentra.sm.dto.web.request.TableReservationReqDTO;
import com.ceyentra.sm.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/table")
    public ResponseEntity<Object> saveTableReservation(@RequestBody TableReservationReqDTO reqDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.saveTableReservation(reqDTO));
    }

    @PostMapping("/meal")
    public ResponseEntity<Object> saveMealOrder(@RequestBody MealOrderReqDTO reqDTO) {
        reservationService.saveMealOrder(reqDTO);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponseDTO.builder()
                .success(true)
                .message("Saved meal order")
                .build());
    }

}
