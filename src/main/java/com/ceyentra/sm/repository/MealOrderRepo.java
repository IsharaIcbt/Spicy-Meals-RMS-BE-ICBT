package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.MealOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealOrderRepo extends JpaRepository<MealOrderEntity, Long> {
}
