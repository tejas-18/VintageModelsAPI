package com.classicmodels.classicmodelsservice.controller;

import com.classicmodels.classicmodelsservice.entity.Customer;
import com.classicmodels.classicmodelsservice.entity.Order;
import com.classicmodels.classicmodelsservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get all orders
    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    // Get order by ID
    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    // Create a new order
    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    // Delete an order by ID
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }

}
