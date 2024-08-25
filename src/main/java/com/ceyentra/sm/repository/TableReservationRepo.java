package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.TableReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableReservationRepo extends JpaRepository<TableReservationEntity, Long> {

    List<TableReservationEntity> findTableReservationEntityByCustomerId(Long id);
}
