package com.insight.learning.platabank.transferenceservice.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@Entity
public class Payee {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;

    @OneToOne
    private Account account;

    private String name;
    private String nickName;
    private String email;

}
