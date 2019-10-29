package com.insight.learning.platabank.transferenceservice.model;

import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Entity
@Data
public class Transference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransferType transferType;

    @Setter(AccessLevel.NONE)
    private LocalDateTime transactionDate = LocalDateTime.now();

    private Account account;
    private Payee payee;
    private Double amount;
    private LocalDateTime transferDate;





}


