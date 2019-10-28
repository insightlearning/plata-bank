package com.insight.learning.platabank.accountservice.repository;

import com.insight.learning.platabank.accountservice.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {}
