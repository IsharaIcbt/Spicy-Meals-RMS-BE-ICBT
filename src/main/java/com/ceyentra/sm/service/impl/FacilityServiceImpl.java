package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.response.FacilityCommonResDTO;
import com.ceyentra.sm.entity.FacilityEntity;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.repository.FacilityRepo;
import com.ceyentra.sm.service.FacilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Object findFacilityById(Long id) {
        log.info("START FUNCTION findFacilityById {} ", id);
        try {
            Optional<FacilityEntity> facility = facilityRepo.findById(id);

            if (facility.isPresent()) {
                return mapFacilityCommonDTO(facility.get());
            }

            throw new ApplicationServiceException(404, false, "restaurant not found");
        } catch (Exception e) {
            log.error("Error in findFacilityById: ", e);
            throw e;
        }

    }

    private FacilityCommonResDTO mapFacilityCommonDTO(FacilityEntity facility) {
        return FacilityCommonResDTO.builder()
                .id(facility.getId())
                .restaurantId(facility.getRestaurant().getId())
                .name(facility.getName())
                .imgURL(facility.getImgURL())
                .description(facility.getDescription())
                .frequency(facility.getFrequency())
                .reservedDate(facility.getReservedDate())
                .start(facility.getStart())
                .close(facility.getClose())
                .weekDays(facility.getWeekDays())
                .maxParticipantCount(facility.getMaxParticipantCount())
                .price(facility.getPrice())
                .discount(facility.getDiscount())
                .facilityType(facility.getFacilityType())
                .availability(facility.getAvailability())
                .createdDate(facility.getCreatedDate())
                .updatedDate(facility.getUpdatedDate())
                .build();
    }
}
