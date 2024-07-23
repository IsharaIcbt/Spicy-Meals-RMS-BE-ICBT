package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepo extends JpaRepository<StaffEntity, Long> {
    Optional<StaffEntity> findByEmail(String email);
}
