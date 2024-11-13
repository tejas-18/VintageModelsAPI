package com.classicmodels.classicmodelsservice.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK id; // Composite Key

    @Column(name = "quantityOrdered", nullable = false)
    private int quantityOrdered;

    @Column(name = "priceEach", nullable = false)
    private double priceEach;

    @Column(name = "orderLineNumber", nullable = false)
    private int orderLineNumber;
}
