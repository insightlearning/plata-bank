package com.insight.learning.platabank.transferenceservice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Account {

    @Id
    private Integer id;
    @ManyToOne
    private Bank bank;
    private Integer agency;
    private Integer dac;
    private String type;

}
