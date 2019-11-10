package com.insight.learning.platabank.transferenceservice.builders;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Account {

    private Integer agency;
    private Integer account;
    private Integer dac;
    private Bank bank;
    private String type;

}
