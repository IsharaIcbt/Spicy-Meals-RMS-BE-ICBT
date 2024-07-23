package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.response.MealResDTO;
import com.ceyentra.sm.repository.MealsRepo;
import com.ceyentra.sm.service.MealService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MealServiceImpl implements MealService {

    private final MealsRepo mealsRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<MealResDTO> findAllMeals() {
        return modelMapper.map(mealsRepo.findAll(),
                new TypeToken<List<MealResDTO>>() {
                }.getType());
    }
}
