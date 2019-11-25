package com.insight.learning.platabank.transferenceservice.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
public class Account {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Bank bank;

    private Integer agency;
    private Integer dac;
    private String type;

}
