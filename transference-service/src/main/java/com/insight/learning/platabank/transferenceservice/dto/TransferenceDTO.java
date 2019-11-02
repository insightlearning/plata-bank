package com.insight.learning.platabank.transferenceservice.dto;

import com.insight.learning.platabank.transferenceservice.builders.Account;
import com.insight.learning.platabank.transferenceservice.builders.Payee;
import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransferenceDTO {

    private Long id;
    private TransferType transferType;
    private LocalDateTime transactionDate = LocalDateTime.now();
    private Account account;
    private Payee payee;
    private Double amount;
    private LocalDateTime transferDate;

}
