package com.insight.learning.platabank.customerservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDto {

    private Long id;
    private String state;
    private String city;
    private String zipCode;
    private String street;
    private int number;
    private String neighborhood;
    private String addOn;
}
