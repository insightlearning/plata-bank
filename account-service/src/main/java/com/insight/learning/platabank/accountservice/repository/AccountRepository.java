package com.insight.learning.platabank.accountservice.repository;

import com.insight.learning.platabank.accountservice.model.Account;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AccountRepository extends Repository<Account, Integer> {
    Account save(Account account);
    Account findById(Integer number);
    List<Account> findAll();
}
