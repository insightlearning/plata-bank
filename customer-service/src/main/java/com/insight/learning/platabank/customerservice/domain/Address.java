package com.insight.learning.platabank.customerservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String state;
    private String city;
    private String zipCode;
    private String street;
    private int number;
    private String neighborhood;
    private String addOn;
}
