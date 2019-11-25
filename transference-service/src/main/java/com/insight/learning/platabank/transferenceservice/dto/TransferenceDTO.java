package com.insight.learning.platabank.transferenceservice.dto;

import com.insight.learning.platabank.transferenceservice.domain.Account;
import com.insight.learning.platabank.transferenceservice.domain.Payee;
import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class TransferenceDTO {

    private Long id;

    @Setter(AccessLevel.NONE)
    private LocalDateTime transactionDate = LocalDateTime.now();

    private TransferType transferType;
    private Account account;
    private Payee payee;
    private Double amount;
    private LocalDateTime transferDate;

}
