package com.classicmodels.classicmodelsservice.serviceImpl;


import java.util.List;
import java.util.Optional;

import com.classicmodels.classicmodelsservice.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classicmodels.classicmodelsservice.entity.OrderDetail;
import com.classicmodels.classicmodelsservice.repository.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderdetailRepository;  // Corrected repository variable

    @Override
    public List<OrderDetail> findAll() {
        return orderdetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.ofNullable(orderdetailRepository.findById(id).orElse(null));
    }

   /* @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderdetailRepository.findById(id);
    }*/

    @Override
    public OrderDetail save(OrderDetail orderdetail) {
        return orderdetailRepository.save(orderdetail);
    }

    @Override
    public void deleteById(Long id) {
        orderdetailRepository.deleteById(id);
    }
}