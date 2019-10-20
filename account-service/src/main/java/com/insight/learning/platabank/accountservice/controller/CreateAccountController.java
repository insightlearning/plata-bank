package com.insight.learning.platabank.accountservice.controller;

import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.model.CheckingAccount;
import com.insight.learning.platabank.accountservice.model.SalaryAccount;
import com.insight.learning.platabank.accountservice.model.SavingAccount;
import com.insight.learning.platabank.accountservice.repository.CheckingAccountRepository;
import com.insight.learning.platabank.accountservice.repository.SalaryAccountRepository;
import com.insight.learning.platabank.accountservice.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/create")
public class CreateAccountController {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    SalaryAccountRepository salaryAccountRepository;

    @Autowired
    SavingAccountRepository savingAccountRepository;

    @GetMapping("checking")
    public Account createCheckingAccount() {
        return checkingAccountRepository.save(new CheckingAccount());
    }

    @GetMapping("salary")
    public Account createSalaryAccount() {
        return salaryAccountRepository.save(new SalaryAccount());
    }

    @GetMapping("saving")
    public Account createSavingAccount() {
        return savingAccountRepository.save(new SavingAccount());
    }
}
