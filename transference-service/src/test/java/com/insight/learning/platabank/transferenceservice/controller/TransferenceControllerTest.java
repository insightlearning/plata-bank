package com.insight.learning.platabank.transferenceservice.controller;

import com.insight.learning.platabank.transferenceservice.builders.*;
import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class TransferenceControllerTest {

    private TransferenceController transferenceController;

    @Test
    public void mustTransferDocToday(){
        //cenario
        Account sourceAccount = AccountBuilder
                .oneAccount()
                .withAgency(1500)
                .withAccount(02345)
                .withDac(2)
                .typeAccount("Conta Corrente")
                .account();

        Payee payee = PayeeBuilder
                .onePayee()
                .yourName("Kaique")
                .account(1324)
                .withCpf(new DecimalFormat("4353453454"))
                .payee();

        Transference docTransference = TransferenceBuilder
                .oneTransference()
                .fromAccount(sourceAccount)
                .toPayee(payee)
                .ofType(TransferType.DOC)
                .ammountValue(100.00)
                .atDate(LocalDateTime.now())
                .transference();

        //acao
        TransferenceDTO transferenceDTO = transferenceController.doTransferece(docTransference);

        //verificacao

    }

}
