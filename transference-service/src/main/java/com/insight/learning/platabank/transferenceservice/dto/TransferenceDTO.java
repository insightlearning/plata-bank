package com.insight.learning.platabank.transferenceservice.dto;

import com.insight.learning.platabank.transferenceservice.domain.Account;
import com.insight.learning.platabank.transferenceservice.domain.Payee;
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
