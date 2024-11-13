package com.classicmodels.classicmodelsservice.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;

@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @Column(name = "customerNumber")
    private int customerNumber;

    @Column(name = "checkNumber", nullable = false)
    private String checkNumber;

    @Column(name = "paymentDate", nullable = false)
    private Date paymentDate;

    @Column(name = "amount", nullable = false)
    private double amount;
}
