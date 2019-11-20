package com.insight.learning.platabank.payeeservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@Entity
public class Bank {

    @Id
    @GeneratedValue
    private long id;
    private Integer ISPB;
    private Integer code;
    private String name;
    private String nickName;

}
