package com.insight.learning.platabank.transferenceservice.controller;

import com.insight.learning.platabank.transferenceservice.model.Account;
import com.insight.learning.platabank.transferenceservice.model.Bank;
import com.insight.learning.platabank.transferenceservice.model.Payee;
import com.insight.learning.platabank.transferenceservice.model.Transference;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TransferenceControllerTest {

    private TransferenceController transferenceController;
    private Transference transference;
    private Account account;
    private Bank bank;
    private Payee payee;
    private Account accountPayee;

    @BeforeAll
    public void init(){
        transference = new Transference();
        account = new Account();
        bank = new Bank();
        payee = new Payee();

        bank.setBankCode(0341);
        bank.setBankName("Plata Bank");
        bank.setBankNickName("Plabank");
        bank.setISPB(324234354);

        account.setAccount(03560);
        account.setAgency(4878);
        account.setDac(1);
        account.setBank(bank);

        Account accountPayee = new Account();
        payee.setAccount(accountPayee);

        transference.setAccount(account);
        transference.setAmount(100.30);
        transference.setPayee(payee);
    }

    @Test
    public void mustTransferDocToday(){
        //cenario
        LocalDateTime now = LocalDateTime.now();


        //acao

        //verificacao

    }

}
