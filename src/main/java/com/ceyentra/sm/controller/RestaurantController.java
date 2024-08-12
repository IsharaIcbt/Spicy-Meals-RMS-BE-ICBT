package com.ceyentra.sm.controller;

import com.ceyentra.sm.config.throttling_config.Throttling;
import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.common.ResponseDTO;
import com.ceyentra.sm.dto.web.request.SaveRestaurantRequestDTO;
import com.ceyentra.sm.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<ResponseDTO<Object>> findAllRestaurants() {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .success(true)
                        .data(restaurantService.findAllRestaurants())
                        .build()
                , HttpStatus.OK
        );
    }

    @GetMapping("/branch/ids")
    public ResponseEntity<ResponseDTO<Object>> getAllRestaurantsIds() {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .success(true)
                        .data(restaurantService.findAllRestaurantsIds())
                        .build()
                , HttpStatus.OK
        );
    }

    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> registerRestaurant(@RequestBody SaveRestaurantRequestDTO saveRestaurantRequestDTO) {
        restaurantService.saveRestaurant(saveRestaurantRequestDTO);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("Restaurant successfully registered.")
                        .build()
                , HttpStatus.OK
        );
    }

    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @GetMapping(value = "/branch/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<Object>> findRestaurantById(@PathVariable Long id) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .success(true)
                        .data(restaurantService.findRestaurantById(id))
                        .build()
                , HttpStatus.OK
        );
    }

}
