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
public class MealServiceImpl implements MealService {

    private final MealsRepo mealsRepo;
    private final ModelMapper modelMapper;
    private final RestaurantRepo restaurantRepo;

    @Override
    public List<MealResDTO> findAllMeals() {
        return modelMapper.map(mealsRepo.findAll(),
                new TypeToken<List<MealResDTO>>() {
                }.getType());
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

            if (saveMealReqDTO.getId() == 0) {
                log.info("SAVE MEAL :- Id {}", 0);
                MealEntity newMealEntity = MealEntity.builder()
                        .name(saveMealReqDTO.getName())
                        .image("https://picsum.photos/seed/1/200/300") // TODO: this image should save s3 but currently set random image
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

                MealEntity newMealEntity = MealEntity.builder()
                        .id(saveMealReqDTO.getId())
                        .name(saveMealReqDTO.getName())
                        .image("https://picsum.photos/seed/1/200/300")// TODO: this image should save s3 but currently set random image
                        .description(saveMealReqDTO.getDescription())
                        .price(saveMealReqDTO.getPrice())
                        .discount(saveMealReqDTO.getDiscount())
                        .rating(saveMealReqDTO.getRating())
                        .subCategory(saveMealReqDTO.getSubCategory())
                        .mainCategory(saveMealReqDTO.getMainCategory())
                        .mealType(saveMealReqDTO.getMealType())
                        .restaurant(restaurantEntity.get())
                        .status(saveMealReqDTO.getStatus())
                        .updatedDate(new Date())
                        .build();

                mealsRepo.save(newMealEntity);
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
