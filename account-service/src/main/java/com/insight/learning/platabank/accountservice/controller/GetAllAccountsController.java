package com.insight.learning.platabank.accountservice.controller;

import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.model.CheckingAccount;
import com.insight.learning.platabank.accountservice.model.SalaryAccount;
import com.insight.learning.platabank.accountservice.model.SavingAccount;
import com.insight.learning.platabank.accountservice.repository.CheckingAccountRepository;
import com.insight.learning.platabank.accountservice.repository.SalaryAccountRepository;
import com.insight.learning.platabank.accountservice.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class GetAllAccountsController {

    @Autowired
    SalaryAccountRepository salaryAccountRepository;

    @Autowired
    SavingAccountRepository savingAccountRepository;

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @GetMapping("/accounts/all")
    public List<Account> getAll() throws ExecutionException, InterruptedException {
        List<Account> allAccounts = new ArrayList<>();

        allAccounts.addAll(checkingAccountRepository.findAll());
        allAccounts.addAll(salaryAccountRepository.findAll());
        allAccounts.addAll(savingAccountRepository.findAll());

        return allAccounts;
    }

}
