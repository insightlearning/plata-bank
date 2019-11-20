package com.insight.learning.platabank.payeeservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class Payee {

    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> account;

    private String fullName;
    private String nickName;
    private String email;

}