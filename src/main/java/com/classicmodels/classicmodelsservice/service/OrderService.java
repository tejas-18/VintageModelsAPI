package com.classicmodels.classicmodelsservice.service;

import java.util.List;

import com.classicmodels.classicmodelsservice.entity.Customer;
import com.classicmodels.classicmodelsservice.entity.Order;

public interface OrderService {
    List<Order> findAll();
    Order findById(Long id);
    Order save(Order order);
    void deleteById(Long id);

}