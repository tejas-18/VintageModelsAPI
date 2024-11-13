package com.classicmodels.classicmodelsservice.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employeeNumber")
    private int employeeNumber;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "officeCode", nullable = false)
    private String officeCode;

    @Column(name = "reportsTo")
    private Integer reportsTo; // Nullable

    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;
}
