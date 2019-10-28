package com.insight.learning.platabank.accountservice.controller;

import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.model.Customer;
import com.insight.learning.platabank.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAccountController {

    private final AccountRepository accountRepository;

    public CreateAccountController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @PostMapping("/account/create")
    public Account createAccount(@RequestBody Customer customer) {
        return accountRepository.save(new Account(customer));
    }
}
