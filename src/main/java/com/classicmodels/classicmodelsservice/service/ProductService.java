package com.classicmodels.classicmodelsservice.service;

import com.classicmodels.classicmodelsservice.entity.Product;
import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(String id);  // Changed from int to String

    Product save(Product product);

    void deleteById(String id);  // Changed from int to String
}
