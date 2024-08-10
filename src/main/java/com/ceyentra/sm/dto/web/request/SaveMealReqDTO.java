package com.ceyentra.sm.dto.web.request;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.MainMealTypes;
import com.ceyentra.sm.enums.MealCategory;
import com.ceyentra.sm.enums.MealTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveMealReqDTO {
    Long id;
    Long restaurantId;
    String name;
    MainMealTypes mainCategory;
    MealTypes subCategory;
    MealCategory mealType;
    Float price;
    Float discount;
    CommonStatus status;
    Long rating;
    String description;
    MultipartFile img;
}
