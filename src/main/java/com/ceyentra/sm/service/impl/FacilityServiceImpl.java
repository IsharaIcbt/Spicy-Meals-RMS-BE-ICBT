package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.request.SaveFacilityReqDTO;
import com.ceyentra.sm.dto.web.response.FacilityCommonResDTO;
import com.ceyentra.sm.entity.FacilityEntity;
import com.ceyentra.sm.entity.RestaurantEntity;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.repository.FacilityRepo;
import com.ceyentra.sm.repository.RestaurantRepo;
import com.ceyentra.sm.service.FacilityService;
import com.ceyentra.sm.util.S3BucketUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.ceyentra.sm.constant.ApplicationConstant.FACILITY_S3_BUCKET_FOLDER;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class FacilityServiceImpl implements FacilityService {

    private final ModelMapper modelMapper;
    private final FacilityRepo facilityRepo;
    private final RestaurantRepo restaurantRepo;
    private final S3BucketUtil s3BucketUtil;


    /**
     * This method is used to generate file names.
     *
     * @param multiPart
     * @return sting file name
     */
    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    @Override
    public void saveFacility(SaveFacilityReqDTO saveFacilityReqDTO) {
        log.info("START FUNCTION saveFacility");
        try {
            //check already exist restaurant
            Optional<RestaurantEntity> restaurantEntity = restaurantRepo.findById(saveFacilityReqDTO.getRestaurantId());
            if (!restaurantEntity.isPresent() || restaurantEntity.get().getStatus().equals(CommonStatus.DELETED)) {
                throw new ApplicationServiceException(200, false, "Restaurant not found");
            }

            // Initialize fileURL variable
            String fileURL = null;
            MultipartFile file = saveFacilityReqDTO.getImgURL();

            // Only attempt to upload the file if it is not null
            if (file != null && !file.isEmpty()) {
                fileURL = s3BucketUtil.uploadMultipartToS3bucket(FACILITY_S3_BUCKET_FOLDER + generateFileName(file), file);
            }

            if (saveFacilityReqDTO.getId() == 0) {
                log.info("SAVE Facility :- Id {}", 0);

                FacilityEntity newFacility = FacilityEntity.builder()
                        .name(saveFacilityReqDTO.getName())
                        .imgURL(fileURL)
                        .description(saveFacilityReqDTO.getDescription())
                        .frequency(saveFacilityReqDTO.getFrequency())
                        .reservedDate(saveFacilityReqDTO.getReservedDate())
                        .start(saveFacilityReqDTO.getStart())
                        .close(saveFacilityReqDTO.getClose())
                        .weekDays(saveFacilityReqDTO.getWeekDays())
                        .maxParticipantCount(saveFacilityReqDTO.getMaxParticipantCount())
                        .price(saveFacilityReqDTO.getPrice())
                        .discount(saveFacilityReqDTO.getDiscount())
                        .facilityType(saveFacilityReqDTO.getFacilityType())
                        .restaurant(restaurantEntity.get())
                        .availability(saveFacilityReqDTO.getAvailability())
                        .build();

                facilityRepo.save(newFacility);
            } else {
                log.info("UPDATE Facility :- Id {}", saveFacilityReqDTO.getId());
                Optional<FacilityEntity> byId = facilityRepo.findById(saveFacilityReqDTO.getId());

                if (!byId.isPresent()) {
                    throw new ApplicationServiceException(200, false, "Sorry required facility  not found");
                }

                // Fetch the existing entity
                FacilityEntity existingFacility = byId.get();

                // If fileURL is null, retain the existing image URL
                if (fileURL == null){
                    fileURL = existingFacility.getImgURL();
                }

                // Update fields while preserving createdDate
                existingFacility.setName(saveFacilityReqDTO.getName());
                existingFacility.setImgURL(fileURL);
                existingFacility.setDescription(saveFacilityReqDTO.getDescription());
                existingFacility.setFrequency(saveFacilityReqDTO.getFrequency());
                existingFacility.setReservedDate(saveFacilityReqDTO.getReservedDate());
                existingFacility.setStart(saveFacilityReqDTO.getStart());
                existingFacility.setClose(saveFacilityReqDTO.getClose());
                existingFacility.setWeekDays(saveFacilityReqDTO.getWeekDays());
                existingFacility.setMaxParticipantCount(saveFacilityReqDTO.getMaxParticipantCount());
                existingFacility.setPrice(saveFacilityReqDTO.getPrice());
                existingFacility.setDiscount(saveFacilityReqDTO.getDiscount());
                existingFacility.setFacilityType(saveFacilityReqDTO.getFacilityType());
                existingFacility.setRestaurant(restaurantEntity.get());
                existingFacility.setAvailability(saveFacilityReqDTO.getAvailability());
                existingFacility.setUpdatedDate(new Date());

                facilityRepo.save(existingFacility);
            }


        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }


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
