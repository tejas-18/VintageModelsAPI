package com.classicmodels.classicmodelsservice.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "productCode")
    private String productCode;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "productLine", nullable = false)
    private String productLine;

    @Column(name = "productScale", nullable = false)
    private String productScale;

    @Column(name = "productVendor", nullable = false)
    private String productVendor;

    @Column(name = "productDescription", nullable = false)
    private String productDescription;

    @Column(name = "quantityInStock", nullable = false)
    private short quantityInStock;

    @Column(name = "buyPrice", nullable = false)
    private double buyPrice;

    @Column(name = "MSRP", nullable = false)
    private double MSRP;
}
