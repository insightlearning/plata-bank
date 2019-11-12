package com.insight.learning.platabank.transferenceservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Data
@RequiredArgsConstructor
@Entity
public class Payee {

    @Id
    private String cpf;

    @OneToOne
    private Account account;

    private String name;
    private String nickName;
    private String email;

}
