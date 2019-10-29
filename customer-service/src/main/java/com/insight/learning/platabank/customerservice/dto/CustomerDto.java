package com.insight.learning.platabank.customerservice.dto;

import com.insight.learning.platabank.customerservice.domain.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import java.util.Date;
import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE) //Hides the constructor to force usage of the Builder.
public class CustomerDto {

    private Long id;
    private Career career;
    private Address address;
    private List<ContactPhone> contactsPhone;
    private Date dateBirth;
    private Status status;
    private Sex sex;
    private String fatherName;
    private String motherName;
    private String fullName;
}
