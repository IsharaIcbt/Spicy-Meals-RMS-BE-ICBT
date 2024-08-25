package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.TableReservationDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableReservationDetailRepo extends JpaRepository<TableReservationDetailEntity, Long> {
    List<TableReservationDetailEntity> findByReservationId(Long id);
}
