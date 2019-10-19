package com.insight.learning.platabank.customerservice.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Address {
    private String state;
    private String city;
    private String zipCode;
    private String street;
    private int number;
    private String neighborhood;
    private String addOn;
}
