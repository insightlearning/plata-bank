package com.insight.learning.platabank.customerservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
public class Career {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    private Address address;

    @OneToOne(cascade=CascadeType.ALL)
    private ContactPhone contactPhone;

    private String occupation;
    private String companyName;

}
