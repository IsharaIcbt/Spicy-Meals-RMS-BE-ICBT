package com.ceyentra.sm.service.impl;

import com.ceyentra.sm.dto.web.request.SaveMealReqDTO;
import com.ceyentra.sm.dto.web.response.MealCommonResDTO;
import com.ceyentra.sm.dto.web.response.MealResDTO;
import com.ceyentra.sm.entity.MealEntity;
import com.ceyentra.sm.entity.RestaurantEntity;
import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.exception.ApplicationServiceException;
import com.ceyentra.sm.repository.MealsRepo;
import com.ceyentra.sm.repository.RestaurantRepo;
import com.ceyentra.sm.service.MealService;
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

import static com.ceyentra.sm.constant.ApplicationConstant.RESUME_S3_BUCKET_FOLDER;


@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class MealServiceImpl implements MealService {

    private final MealsRepo mealsRepo;
    private final ModelMapper modelMapper;
    private final RestaurantRepo restaurantRepo;
    private final S3BucketUtil s3BucketUtil;

    @Override
    public List<MealResDTO> findAllMeals() {
        return modelMapper.map(mealsRepo.findAll(),
                new TypeToken<List<MealResDTO>>() {
                }.getType());
    }

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
    public void saveMeal(SaveMealReqDTO saveMealReqDTO) {
        log.info("START FUNCTION saveMeal");
        try {
            //check already exist restaurant
            Optional<RestaurantEntity> restaurantEntity = restaurantRepo.findById(saveMealReqDTO.getRestaurantId());
            if (!restaurantEntity.isPresent() || restaurantEntity.get().getStatus().equals(CommonStatus.DELETED)) {
                throw new ApplicationServiceException(200, false, "Restaurant not found");
            }
            MultipartFile file = saveMealReqDTO.getImg();
            String fileURL  = s3BucketUtil.uploadMultipartToS3bucket(RESUME_S3_BUCKET_FOLDER + generateFileName(saveMealReqDTO.getImg()), saveMealReqDTO.getImg());
            if (saveMealReqDTO.getId() == 0) {



                log.info("SAVE MEAL :- Id {}", 0);
                MealEntity newMealEntity = MealEntity.builder()
                        .name(saveMealReqDTO.getName())
                        .image(fileURL)
                        .description(saveMealReqDTO.getDescription())
                        .price(saveMealReqDTO.getPrice())
                        .discount(saveMealReqDTO.getDiscount())
                        .rating(saveMealReqDTO.getRating())
                        .subCategory(saveMealReqDTO.getSubCategory())
                        .mainCategory(saveMealReqDTO.getMainCategory())
                        .mealType(saveMealReqDTO.getMealType())
                        .restaurant(restaurantEntity.get())
                        .status(saveMealReqDTO.getStatus())
                        .build();

                mealsRepo.save(newMealEntity);
            } else {
                log.info("UPDATE MEAL :- Id {}", saveMealReqDTO.getId());
                Optional<MealEntity> byId = mealsRepo.findById(saveMealReqDTO.getId());

                if (!byId.isPresent()) {
                    throw new ApplicationServiceException(200, false, "Sorry required meal  not found");
                }

                // Fetch the existing entity
                MealEntity existingMealEntity = byId.get();

                // Update the necessary fields while preserving createdDate
                existingMealEntity.setName(saveMealReqDTO.getName());
                existingMealEntity.setImage(fileURL);
                existingMealEntity.setDescription(saveMealReqDTO.getDescription());
                existingMealEntity.setPrice(saveMealReqDTO.getPrice());
                existingMealEntity.setDiscount(saveMealReqDTO.getDiscount());
                existingMealEntity.setRating(saveMealReqDTO.getRating());
                existingMealEntity.setSubCategory(saveMealReqDTO.getSubCategory());
                existingMealEntity.setMainCategory(saveMealReqDTO.getMainCategory());
                existingMealEntity.setMealType(saveMealReqDTO.getMealType());
                existingMealEntity.setRestaurant(restaurantEntity.get());
                existingMealEntity.setStatus(saveMealReqDTO.getStatus());
                existingMealEntity.setUpdatedDate(new Date()); // Update the updated date

                // Save the updated entity
                mealsRepo.save(existingMealEntity);
            }
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

    @Override
    public Object findMealById(Long id) {
        log.info("START FUNCTION findMealById {} ", id);
        try {
            Optional<MealEntity> meal = mealsRepo.findById(id);

            if (meal.isPresent()) {
                return mapMealCommonDTO(meal.get());
            }

            throw new ApplicationServiceException(404, false, "Meal not found");
        } catch (Exception e) {
            log.error("Error in findOneAdminPortalUser: ", e);
            throw e;
        }
    }

    private MealCommonResDTO mapMealCommonDTO(MealEntity meal) {
        return MealCommonResDTO.builder()
                .id(meal.getId())
                .restaurantId(meal.getRestaurant().getId())
                .name(meal.getName())
                .mainCategory(meal.getMainCategory())
                .subCategory(meal.getSubCategory())
                .mealType(meal.getMealType())
                .price(meal.getPrice())
                .discount(meal.getDiscount())
                .status(meal.getStatus())
                .rating(meal.getRating())
                .description(meal.getDescription())
                .img(meal.getImage())
                .createdDate(meal.getCreatedDate())
                .updatedDate(meal.getUpdatedDate())
                .build();
    }
}
