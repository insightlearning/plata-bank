package com.insight.learning.platabank.accountservice.controller;

import com.insight.learning.platabank.accountservice.enumerator.AccountStatus;
import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.model.Customer;
import com.insight.learning.platabank.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Customer customer) {
        return accountService.createAccount(customer);
    }

    @GetMapping("/{number}/balance")
    public double getAccountBalance(@PathVariable int number) {
        return accountService.getAccountBalance(number);
    }

    @GetMapping("/{number}/status")
    public AccountStatus getAccountStatus(@PathVariable int number) {
        return accountService.getAccountStatus(number);
    }

    @PatchMapping("/{number}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateAccountStatus(@PathVariable int number) {
        accountService.deactivateAccount(number);
    }
}
