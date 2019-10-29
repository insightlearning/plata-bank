package com.insight.learning.platabank.accountservice.repository;

import com.insight.learning.platabank.accountservice.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface AccountRepository extends Repository<Account, Integer> {
    Account save(Account a);
    Optional<Account> findById(int number);
}
