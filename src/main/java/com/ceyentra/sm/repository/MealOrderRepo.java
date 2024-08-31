package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.MealOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MealOrderRepo extends JpaRepository<MealOrderEntity, Long> {

    List<MealOrderEntity> findByUserEntityId(Long id);

    @Query("FROM MealOrderEntity WHERE MealOrderEntity.id=:id")
    List<MealOrderEntity> findByIdV2(Long id);
}
