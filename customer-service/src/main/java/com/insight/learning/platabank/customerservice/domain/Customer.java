package com.insight.learning.platabank.customerservice.domain;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Customer {
    @Id
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    private Career career;

    @OneToOne(cascade=CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ContactPhone> contactsPhone;

    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String fatherName;
    private String motherName;
    private String fullName;

    public Customer(Long id, Career career, Address address, List<ContactPhone> contactsPhone, Date dateBirth, Sex sex, String fatherName, String motherName, String fullName) {
        this.id = id;
        this.career = career;
        this.address = address;
        this.contactsPhone = contactsPhone;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.fullName = fullName;
        this.status = status.PENDING;
    }


}
