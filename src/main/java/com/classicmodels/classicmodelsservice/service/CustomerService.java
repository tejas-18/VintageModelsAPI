package com.classicmodels.classicmodelsservice.service;

import java.util.List;
import com.classicmodels.classicmodelsservice.entity.Customer;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    Customer save(Customer customer);
    void deleteById(int id);
}