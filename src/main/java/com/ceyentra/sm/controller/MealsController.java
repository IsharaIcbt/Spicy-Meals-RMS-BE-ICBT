package com.ceyentra.sm.controller;

import com.ceyentra.sm.dto.web.response.MealsFilterResDTO;
import com.ceyentra.sm.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
