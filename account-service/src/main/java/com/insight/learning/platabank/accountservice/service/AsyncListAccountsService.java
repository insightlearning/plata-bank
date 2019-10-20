package com.insight.learning.platabank.accountservice.service;

import com.insight.learning.platabank.accountservice.enumerator.AccountType;
import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.repository.CheckingAccountRepository;
import com.insight.learning.platabank.accountservice.repository.SalaryAccountRepository;
import com.insight.learning.platabank.accountservice.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncListAccountsService {

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    @Autowired
    private SavingAccountRepository savingAccountRepository;

    @Autowired
    private SalaryAccountRepository salaryAccountRepository;

    @Async
    public CompletableFuture<List<Account>> getAccounts(AccountType type){
        List<Account> accounts = new ArrayList<>();

        switch(type){
            case CHECKING: accounts.addAll(checkingAccountRepository.findAll()); break;
            case SAVING: accounts.addAll(savingAccountRepository.findAll()); break;
            case SALARY: accounts.addAll(salaryAccountRepository.findAll()); break;
        }

        return CompletableFuture.completedFuture(accounts);
    }
}
