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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerDTO {

    private Long id;
    private CareerDTO career;
    private AddressDTO address;
    private List<ContactPhoneDTO> contactsPhone;
    private Date dateBirth;
    private Status status;
    private Sex sex;
    private String fatherName;
    private String motherName;
    private String fullName;
}
