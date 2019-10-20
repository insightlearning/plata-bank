package com.insight.learning.platabank.customerservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Address address;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private ContactPhone contactPhone;
    private String occupation;
    private String companyName;

}
