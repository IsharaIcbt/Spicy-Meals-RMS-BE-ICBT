package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.request.SaveRestaurantRequestDTO;
import com.ceyentra.sm.dto.web.response.RestaurantResponseDTO;

import java.util.List;

public interface RestaurantService {
    List<RestaurantResponseDTO> findAllRestaurants();


    void saveRestaurant(SaveRestaurantRequestDTO saveRestaurantRequestDTO);
}
