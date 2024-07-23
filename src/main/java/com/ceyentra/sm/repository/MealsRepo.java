package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealsRepo extends JpaRepository<MealEntity, Long> {
}
