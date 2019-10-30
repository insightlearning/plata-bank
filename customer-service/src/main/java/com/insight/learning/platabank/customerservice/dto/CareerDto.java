package com.insight.learning.platabank.customerservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CareerDto {

    private Long id;
    private AddressDto address;
    private ContactPhoneDto contactPhone;
    private String occupation;
    private String companyName;
}
