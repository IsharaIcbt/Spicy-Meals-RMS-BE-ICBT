package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.request.SaveRestaurantRequestDTO;
import com.ceyentra.sm.dto.web.response.RestaurantResponseDTO;
import com.ceyentra.sm.entity.RestaurantEntity;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.repository.RestaurantRepo;
import com.ceyentra.sm.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class RestaurantServiceImpl implements RestaurantService {

    private final ModelMapper modelMapper;
    private final RestaurantRepo restaurantRepo;

    @Override
    public List<RestaurantResponseDTO> findAllRestaurants() {
        return modelMapper.map(restaurantRepo.findAll(), new TypeToken<List<RestaurantResponseDTO>>() {
        }.getType());
    }


    @Override
    public void saveRestaurant(SaveRestaurantRequestDTO saveRestaurantRequestDTO) {

        try {
            if (saveRestaurantRequestDTO.getId() == 0) {
                RestaurantEntity newRestaurant = RestaurantEntity.builder()
                        .name(saveRestaurantRequestDTO.getName())
                        .email(saveRestaurantRequestDTO.getEmail())
                        .address(saveRestaurantRequestDTO.getAddress())
                        .branchCode(saveRestaurantRequestDTO.getBranchCode())
                        .phone(saveRestaurantRequestDTO.getPhone())
                        .status(saveRestaurantRequestDTO.getStatus())
                        .build();

                restaurantRepo.save(newRestaurant);
            } else {
                Optional<RestaurantEntity> byId = restaurantRepo.findById(saveRestaurantRequestDTO.getId());

                if (!byId.isPresent()) {
                    throw new ApplicationServiceException(200, false, "Sorry required restaurant  not found");
                }
                RestaurantEntity newRestaurant = RestaurantEntity.builder()
                        .id(saveRestaurantRequestDTO.getId())
                        .name(saveRestaurantRequestDTO.getName())
                        .email(saveRestaurantRequestDTO.getEmail())
                        .address(saveRestaurantRequestDTO.getAddress())
                        .branchCode(saveRestaurantRequestDTO.getBranchCode())
                        .phone(saveRestaurantRequestDTO.getPhone())
                        .updatedDate(new Date())
                        .status(saveRestaurantRequestDTO.getStatus())
                        .build();

                restaurantRepo.save(newRestaurant);
            }


        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }
}

