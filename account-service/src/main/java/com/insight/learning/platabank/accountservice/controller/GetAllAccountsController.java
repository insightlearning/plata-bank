package com.insight.learning.platabank.accountservice.controller;

import com.insight.learning.platabank.accountservice.enumerator.AccountType;
import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.service.AsyncListAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class GetAllAccountsController {

    @Autowired
    AsyncListAccountsService asyncListAccountsService;

    @GetMapping("/accounts/all")
    public List<Account> getAll() throws ExecutionException, InterruptedException {
        List<Account> allAccounts = new ArrayList<>();

        CompletableFuture<List<Account>> checking = asyncListAccountsService.getAccounts(AccountType.CHECKING);
        CompletableFuture<List<Account>> saving = asyncListAccountsService.getAccounts(AccountType.SAVING);
        CompletableFuture<List<Account>> salary = asyncListAccountsService.getAccounts(AccountType.SALARY);

        CompletableFuture.allOf(checking, saving, salary).join();

        allAccounts.addAll(checking.get());
        allAccounts.addAll(saving.get());
        allAccounts.addAll(salary.get());

        return allAccounts;
    }

}
