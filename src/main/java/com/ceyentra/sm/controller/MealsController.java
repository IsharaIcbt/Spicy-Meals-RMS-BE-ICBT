package com.ceyentra.sm.controller;

import com.ceyentra.sm.config.throttling_config.Throttling;
import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.common.ResponseDTO;
import com.ceyentra.sm.dto.web.request.SaveMealReqDTO;
import com.ceyentra.sm.dto.web.response.MealsFilterResDTO;
import com.ceyentra.sm.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/v1/meal")
@RequiredArgsConstructor
public class MealsController {

    private final MealService mealService;

    @GetMapping
    public ResponseEntity<Object> findAllMeals() {
        MealsFilterResDTO filterResDTO = MealsFilterResDTO.builder()
                .restaurantId(0L)
                .meals(mealService.findAllMeals())
                .build();

        return ResponseEntity.status(200).body(filterResDTO);
    }

    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDTO> saveMeal(@ModelAttribute SaveMealReqDTO saveMealReqDTO) {
        mealService.saveMeal(saveMealReqDTO);
        return new ResponseEntity<>(
                CommonResponseDTO.builder()
                        .success(true)
                        .message("Meal successfully Saved.")
                        .build()
                , HttpStatus.OK
        );
    }

    @Throttling(timeFrameInSeconds = 60, calls = 20)
    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<Object>> findSpecificMealById(@PathVariable Long id) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .success(true)
                        .data(mealService.findMealById(id))
                        .build()
                , HttpStatus.OK
        );
    }



}
