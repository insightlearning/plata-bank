package com.insight.learning.platabank.accountservice.repository;

import com.insight.learning.platabank.accountservice.model.CheckingAccount;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CheckingAccountRepository extends Repository<CheckingAccount, Integer> {
    CheckingAccount save(CheckingAccount account);
    CheckingAccount findById(Integer number);
    List<CheckingAccount> findAll();
}
