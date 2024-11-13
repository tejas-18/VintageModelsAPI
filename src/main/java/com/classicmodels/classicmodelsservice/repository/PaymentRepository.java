package com.classicmodels.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classicmodels.classicmodelsservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}