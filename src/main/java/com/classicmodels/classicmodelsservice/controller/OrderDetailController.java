package com.classicmodels.classicmodelsservice.controller;

import com.classicmodels.classicmodelsservice.entity.OrderDetail;
import com.classicmodels.classicmodelsservice.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {

    @Autowired
    private OrderDetailService service;

    @GetMapping
    public List<OrderDetail> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<OrderDetail> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public OrderDetail save(@RequestBody OrderDetail orderDetail) {
        return service.save(orderDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
