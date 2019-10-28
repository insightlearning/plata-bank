package com.insight.learning.platabank.transferenceservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@RequiredArgsConstructor
@Entity
public class Payee {

    @Id
    private Integer cpf;
    private String name;
    private Account account;

}
