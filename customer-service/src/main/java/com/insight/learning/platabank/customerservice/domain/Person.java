package com.insight.learning.platabank.customerservice.domain;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class Person {
    private String fullName;
    private LocalDate dateBirth;
    private List<ContactPhone> contactsPhone;
    private String fatherName;
    private String motherName;
    private Sex sex;
    private Career career;
    private Address address;
}
