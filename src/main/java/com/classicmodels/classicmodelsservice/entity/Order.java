package com.classicmodels.classicmodelsservice.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {

//    @Id
//    @Column(name = "orderNumber")
//    private int orderNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;

    private Date orderDate;
    private String status;
    private Long customerNumber; // Foreign key reference to the customer table

    @Transient  // This field won't be persisted in the database
    private Customer customer;

//    @Column(name = "orderDate", nullable = false)
//    private Date orderDate;

    @Column(name = "requiredDate", nullable = false)
    private Date requiredDate;

    @Column(name = "shippedDate")
    private Date shippedDate; // Nullable

//    @Column(name = "status", nullable = false)
//    private String status;

    @Column(name = "comments")
    private String comments; // Nullable


//    @Column(name = "customerNumber", nullable = false)
//    private int customerNumber;

}
