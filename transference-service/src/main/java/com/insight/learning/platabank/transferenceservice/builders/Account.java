package com.insight.learning.platabank.transferenceservice.builders;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Data
@RequiredArgsConstructor
@Entity
public class Account {

    private Integer agency;
    private Integer account;
    private Integer dac;
    private Bank bank;
    private String type;

}
