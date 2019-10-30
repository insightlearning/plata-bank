package com.insight.learning.platabank.customerservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class ContactPhone {

    @Id
    @GeneratedValue
    private Long id;

    private String contactType;
    private String countryCode;
    private String areaCode;
    private String number;
}
