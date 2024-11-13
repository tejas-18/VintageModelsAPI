package com.classicmodels.classicmodelsservice.controller;

import com.classicmodels.classicmodelsservice.entity.Payment;
import com.classicmodels.classicmodelsservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public List<Payment> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Payment findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Payment save(@RequestBody Payment payment) {
        return service.save(payment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }
}
