package com.insight.learning.platabank.transferenceservice.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@Entity
public class Bank {

    @Id
    private Integer ISPB;
    private Integer bankCode;
    private String bankName;
    private String bankNickName;
}
