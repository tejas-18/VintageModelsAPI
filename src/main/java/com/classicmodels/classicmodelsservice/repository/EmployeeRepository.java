package com.classicmodels.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classicmodels.classicmodelsservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}