package com.insight.learning.platabank.accountservice.controller;

import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.model.Customer;
import com.insight.learning.platabank.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/account/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Customer customer) {
        return accountService.createAccount(customer);
    }

    @GetMapping("/account/{number}/balance")
    public double deactivatedAccount(@PathVariable int number) {
        return accountService.getAccountBalance(number);
    }
}
