package com.insight.learning.platabank.customerservice.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
public class Customer {
    @Id
    private Long id;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Career career;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Address address;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
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
