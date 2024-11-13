package com.classicmodels.classicmodelsservice.service;

import com.classicmodels.classicmodelsservice.entity.OrderDetail;
import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(Long id);  // Change int to Long

    OrderDetail save(OrderDetail orderDetail);
    void deleteById(Long id);  // Change int to Long
}
