package com.insight.learning.platabank.customerservice.dto;

import com.insight.learning.platabank.customerservice.domain.AccountStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDto {
    private int number;
    private double balance;
    private AccountStatus status;
    private CustomerDto customerdto;
}
