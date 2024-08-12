package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.response.FacilityCommonResDTO;
import com.ceyentra.sm.dto.web.response.RestaurantResponseDTO;
import com.ceyentra.sm.repository.FacilityRepo;
import com.ceyentra.sm.service.FacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class FacilityServiceImpl implements FacilityService {

    private final ModelMapper modelMapper;
    private final FacilityRepo facilityRepo;


    @Override
    public List<FacilityCommonResDTO> findAllFacilities() {
        return modelMapper.map(facilityRepo.findAll(), new TypeToken<List<FacilityCommonResDTO>>() {
        }.getType());
    }
}
