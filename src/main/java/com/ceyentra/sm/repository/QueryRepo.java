package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.QueryEntity;
import com.ceyentra.sm.enums.QueryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueryRepo extends JpaRepository<QueryEntity, Long> {

    List<QueryEntity> findAllByMealOrder_IdOrderByCreatedDate(Long id);
    List<QueryEntity> findAllByTableReservation_IdOrderByCreatedDate(Long id);
    List<QueryEntity> findQueryEntitiesByQueryTypeAndUser_IdOrderByCreatedDate(QueryType queryType, Long userId);
}
