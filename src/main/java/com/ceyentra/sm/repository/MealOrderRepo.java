package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.MealOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealOrderRepo extends JpaRepository<MealOrderEntity, Long> {

    List<MealOrderEntity> findByUserEntityId(Long id);
}
