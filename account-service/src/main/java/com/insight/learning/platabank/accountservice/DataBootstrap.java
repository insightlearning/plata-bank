package com.insight.learning.platabank.accountservice;

import com.insight.learning.platabank.accountservice.model.CheckingAccount;
import com.insight.learning.platabank.accountservice.model.SalaryAccount;
import com.insight.learning.platabank.accountservice.model.SavingAccount;
import com.insight.learning.platabank.accountservice.repository.CheckingAccountRepository;
import com.insight.learning.platabank.accountservice.repository.SalaryAccountRepository;
import com.insight.learning.platabank.accountservice.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements CommandLineRunner {

    @Autowired
    SalaryAccountRepository salaryAccountRepository;

    @Autowired
    SavingAccountRepository savingAccountRepository;

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Override
    public void run(String... args) throws Exception {

        for(int i = 0; i < 15; i++){
            if(i < 5){
                salaryAccountRepository.save(new SalaryAccount());
            } else if(i < 10){
                savingAccountRepository.save(new SavingAccount());
            } else{
                checkingAccountRepository.save(new CheckingAccount());
            }
        }

    }
}
