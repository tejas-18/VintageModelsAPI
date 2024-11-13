package com.classicmodels.classicmodelsservice.serviceImpl;


import java.util.List;

import com.classicmodels.classicmodelsservice.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classicmodels.classicmodelsservice.entity.ProductLine;
import com.classicmodels.classicmodelsservice.repository.ProductLineRepository;

@Service
public class ProductLineServiceImpl implements ProductLineService {

    @Autowired
    private ProductLineRepository productlineRepository;  // Corrected repository variable

    @Override
    public List<ProductLine> findAll() {
        return productlineRepository.findAll();
    }

    @Override
    public ProductLine findById(int id) {
        return productlineRepository.findById(id).orElse(null);
    }

    @Override
    public ProductLine save(ProductLine productline) {
        return productlineRepository.save(productline);
    }

    @Override
    public void deleteById(int id) {
        productlineRepository.deleteById(id);
    }
}