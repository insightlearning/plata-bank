package com.insight.learning.platabank.accountservice.repository;

import com.insight.learning.platabank.accountservice.model.SalaryAccount;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SalaryAccountRepository extends Repository<SalaryAccount, Integer> {
    SalaryAccount save(SalaryAccount account);
    SalaryAccount findById(Integer number);
    List<SalaryAccount> findAll();
}
