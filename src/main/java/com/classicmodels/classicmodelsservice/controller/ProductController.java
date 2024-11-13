package com.classicmodels.classicmodelsservice.controller;

import com.classicmodels.classicmodelsservice.entity.Product;
import com.classicmodels.classicmodelsservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    // Get product by ID (String id)
    @GetMapping("/{id}")
    public Product findById(@PathVariable String id) {  // Change int to String
        return productService.findById(id);
    }

    // Create a new product
    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    // Delete a product by ID (String id)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {  // Change int to String
        productService.deleteById(id);
    }
}
