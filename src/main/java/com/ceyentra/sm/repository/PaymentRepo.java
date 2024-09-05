package com.ceyentra.sm.repository;

import com.ceyentra.sm.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
