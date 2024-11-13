package com.classicmodels.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classicmodels.classicmodelsservice.entity.OrderDetail;

import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}