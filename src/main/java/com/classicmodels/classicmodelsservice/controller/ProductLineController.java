package com.classicmodels.classicmodelsservice.controller;

import com.classicmodels.classicmodelsservice.entity.ProductLine;
import com.classicmodels.classicmodelsservice.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-lines")
public class ProductLineController {

    @Autowired
    private ProductLineService service;

    @GetMapping
    public List<ProductLine> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductLine findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public ProductLine save(@RequestBody ProductLine productLine) {
        return service.save(productLine);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }
}
