package com.classicmodels.classicmodelsservice.service;

import java.util.List;
import com.classicmodels.classicmodelsservice.entity.ProductLine;

public interface ProductLineService {
    List<ProductLine> findAll();
    ProductLine findById(int id);
    ProductLine save(ProductLine productline);
    void deleteById(int id);
}