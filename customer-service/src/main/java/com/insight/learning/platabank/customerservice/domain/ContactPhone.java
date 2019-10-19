package com.insight.learning.platabank.customerservice.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContactPhone {
    private String contactType;
    private String countryCode;
    private String areaCode;
    private String number;
}
