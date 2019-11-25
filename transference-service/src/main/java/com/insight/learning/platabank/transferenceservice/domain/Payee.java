package com.insight.learning.platabank.transferenceservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Data
@RequiredArgsConstructor
@Entity
public class Payee {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Account account;

    private String cpf;
    private String name;
    private String nickName;
    private String email;

}
