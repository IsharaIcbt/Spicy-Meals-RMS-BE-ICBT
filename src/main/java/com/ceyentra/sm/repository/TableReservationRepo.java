package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.TableReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableReservationRepo extends JpaRepository<TableReservationEntity, Long> {
}
