package com.insight.learning.platabank.transferenceservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

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
