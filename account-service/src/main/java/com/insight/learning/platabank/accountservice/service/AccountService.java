package com.insight.learning.platabank.accountservice.service;

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


    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Customer customer){
       return accountRepository.save(new Account(customer));
    }

    public Double getAccountBalance(int number){
        Optional<Account> account = accountRepository.findById(number);
        return account.map(a -> a.getBalance()).orElseThrow(RuntimeException::new); //Need to create a CustomException
    }

}
