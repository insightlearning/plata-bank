package com.insight.learning.platabank.payeeservice.repository;

import com.insight.learning.platabank.payeeservice.domain.Payee;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PayeeRepository extends Repository<Payee, Long> {

    Payee save(Payee payee);
    Optional<Payee> findById(Long id);
    void deleteById(Long id);



}
