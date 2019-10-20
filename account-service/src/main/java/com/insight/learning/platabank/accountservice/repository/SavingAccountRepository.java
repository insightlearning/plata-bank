package com.insight.learning.platabank.accountservice.repository;

import com.insight.learning.platabank.accountservice.model.SavingAccount;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SavingAccountRepository extends Repository<SavingAccount, Integer> {
    SavingAccount save(SavingAccount account);
    SavingAccount findById(Integer number);
    List<SavingAccount> findAll();
}
