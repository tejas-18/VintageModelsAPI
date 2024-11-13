package com.classicmodels.classicmodelsservice.repository;

import com.classicmodels.classicmodelsservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    // Note: String is used as the ID type here
}
