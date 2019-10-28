package com.insight.learning.platabank.accountservice;

import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.model.Customer;
import com.insight.learning.platabank.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements CommandLineRunner {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

        Customer c = new Customer();
        c.setId(40457446L);
        c.setFullName("Bruno Padovese");

        for(int i = 0; i < 15; i++){
            accountRepository.save(new Account(c));
        }

    }
}
