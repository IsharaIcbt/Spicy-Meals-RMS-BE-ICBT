package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findByEmail(String username);
}