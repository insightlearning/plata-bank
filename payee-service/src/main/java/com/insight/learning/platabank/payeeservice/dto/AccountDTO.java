package com.insight.learning.platabank.payeeservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDTO {

    private Integer id;
    private BankDTO bank;
    private Integer agency;
    private Integer dac;
    private String type;
}
