package com.classicmodels.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classicmodels.classicmodelsservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}