package com.classicmodels.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.classicmodels.classicmodelsservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}