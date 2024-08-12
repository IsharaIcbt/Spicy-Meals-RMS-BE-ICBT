package com.ceyentra.sm.service;

import com.ceyentra.sm.dto.web.response.FacilityCommonResDTO;

import java.util.List;

public interface FacilityService {
    List<FacilityCommonResDTO> findAllFacilities();

    Object findFacilityById(Long id);
}
