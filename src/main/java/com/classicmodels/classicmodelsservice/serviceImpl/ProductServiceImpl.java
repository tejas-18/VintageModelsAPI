package com.classicmodels.classicmodelsservice.serviceImpl;

import com.classicmodels.classicmodelsservice.entity.Product;
import com.classicmodels.classicmodelsservice.repository.ProductRepository;
import com.classicmodels.classicmodelsservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {  // Changed from int to String
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);  // Return null or handle exception if product not found
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(String id) {  // Changed from int to String
        productRepository.deleteById(id);
    }
}
