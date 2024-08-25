package com.ceyentra.sm.controller;

import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.common.ResponseDTO;
import com.ceyentra.sm.dto.web.request.MealOrderReqDTO;
import com.ceyentra.sm.dto.web.request.SaveQueryReqDTO;
import com.ceyentra.sm.dto.web.request.TableReservationReqDTO;
import com.ceyentra.sm.enums.QueryType;
import com.ceyentra.sm.service.QueryService;
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
    private final QueryService queryService;

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

    @GetMapping("/{type}/{orderId}")
    public ResponseEntity<Object> getReservations(@PathVariable QueryType type, @PathVariable Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder()
                .success(true)
                .data(queryService.getQueries(type, orderId))
                .build());
    }

    @PostMapping("/query")
    public ResponseEntity<Object> saveQuery(@RequestBody SaveQueryReqDTO reqDTO) {
        queryService.save(reqDTO);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponseDTO.builder()
                .success(true)
                .message("Saved query")
                .build());
    }

    @GetMapping("/query/{type}/{userId}")
    public ResponseEntity<Object> getQueries(@PathVariable QueryType type, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder()
                .success(true)
                .data(queryService.getQueries(type, userId))
                .build());
    }

}
