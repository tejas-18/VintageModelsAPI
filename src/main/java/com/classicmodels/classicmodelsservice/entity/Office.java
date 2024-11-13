package com.classicmodels.classicmodelsservice.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "offices")
public class Office {

    @Id
    @Column(name = "officeCode")
    private String officeCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "addressLine1", nullable = false)
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "state")
    private String state;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "postalCode", nullable = false)
    private String postalCode;

    @Column(name = "territory")
    private String territory;
}
