package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.request.SaveMealReqDTO;
import com.ceyentra.sm.dto.web.response.MealResDTO;
import com.ceyentra.sm.dto.web.response.MealResponseDTO;

import java.util.List;

public interface MealService {

    List<MealResDTO> findAllMeals();

    void saveMeal(SaveMealReqDTO saveMealReqDTO);

    Object findMealById(Long id);

    List<MealResponseDTO> getAllMeals();
}
