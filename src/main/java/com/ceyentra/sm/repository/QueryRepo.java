package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.QueryEntity;
import com.ceyentra.sm.enums.QueryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueryRepo extends JpaRepository<QueryEntity, Long> {

    List<QueryEntity> findAllByMealOrder_IdOrderByCreatedDate(Long id);

    List<QueryEntity> findAllByTableReservation_IdOrderByCreatedDate(Long id);

    List<QueryEntity> findQueryEntitiesByQueryTypeAndUser_IdOrderByCreatedDate(QueryType queryType, Long userId);

    @Query(value = "SELECT qe FROM QueryEntity qe WHERE qe.status='ACTIVE' AND qe.queryType='CUSTOM' AND qe.user.id=:userId")
    List<QueryEntity> findCustomQueriesByUser(Long userId);
}
