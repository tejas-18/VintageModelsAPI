package com.classicmodels.classicmodelsservice.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
public class OrderDetailPK implements Serializable {

    // Getters and Setters
    private int orderNumber;

    private String productCode;

    // Default constructor
    public OrderDetailPK() {}

    // Parameterized constructor
    public OrderDetailPK(int orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailPK that)) return false;
        return orderNumber == that.orderNumber && Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode);
    }
}
