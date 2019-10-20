package com.insight.learning.platabank.customerservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
