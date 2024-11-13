package com.classicmodels.classicmodelsservice.service;

import java.util.List;
import com.classicmodels.classicmodelsservice.entity.Payment;

public interface PaymentService {
    List<Payment> findAll();
    Payment findById(int id);
    Payment save(Payment payment);
    void deleteById(int id);
}