package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.MealOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealOrderDetailRepo extends JpaRepository<MealOrderDetail, Long> {

    List<MealOrderDetail> findByMealOrderId(Long id);
}
