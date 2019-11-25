package com.insight.learning.platabank.accountservice.service;

import com.insight.learning.platabank.accountservice.enumerator.AccountStatus;
import com.insight.learning.platabank.accountservice.exception.AccountNotFoundException;
import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.model.Customer;
import com.insight.learning.platabank.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author padovese
 * @since 28/10/2019
 */

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Customer customer) {
        return accountRepository.save(new Account(customer));
    }

    public double getAccountBalance(int number) {
        return getAccount(number).map(a -> a.getBalance()).orElseThrow(AccountNotFoundException::new);
    }

    public AccountStatus getAccountStatus(int number) {
        return getAccount(number).map(a -> a.getStatus()).orElseThrow(AccountNotFoundException::new);
    }

    public Optional<Account> getAccount(int number) {
        return accountRepository.findById(number);
    }

    public void deactivateAccount(int number) {
        //TODO: implementation
    }
}
