package com.insight.learning.platabank.transferenceservice.domain;

import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Entity
@Data
public class Transference {

    @Id
    @Setter(AccessLevel.NONE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransferType transferType;

    @Setter(AccessLevel.NONE)
    private LocalDateTime transactionDate = LocalDateTime.now();

    @OneToOne
    private Account account;

    @OneToOne
    private Payee payee;

    private Double amount;
    private LocalDateTime transferDate;





}


