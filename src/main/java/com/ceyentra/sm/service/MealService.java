package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.response.MealResDTO;

import java.util.List;

public interface MealService {

    List<MealResDTO> findAllMeals();

}
