package com.insight.learning.platabank.transferenceservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@Entity
public class Payee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Account account;

    private String cpf;
    private String name;
    private String nickName;
    private String email;

}
