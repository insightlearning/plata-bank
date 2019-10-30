package com.insight.learning.platabank.customerservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactPhoneDto {

    private Long id;
    private String contactType;
    private String countryCode;
    private String areaCode;
    private String number;
}