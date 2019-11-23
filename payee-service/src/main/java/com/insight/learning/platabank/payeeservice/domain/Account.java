package com.insight.learning.platabank.payeeservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Bank bank;

    private Integer agency;
    private Integer dac;
    private String type;

}
