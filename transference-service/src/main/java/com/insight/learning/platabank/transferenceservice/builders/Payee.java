package com.insight.learning.platabank.transferenceservice.builders;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.DecimalFormat;


@Data
@RequiredArgsConstructor
@Entity
public class Payee {

    @Id
    private DecimalFormat cpf;
    private String name;
    private Integer account;

}
