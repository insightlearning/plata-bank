package com.insight.learning.platabank.customerservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CareerDTO {

    private Long id;
    private AddressDTO address;
    private ContactPhoneDTO contactPhone;
    private String occupation;
    private String companyName;
}
