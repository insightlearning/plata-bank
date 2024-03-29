package com.insight.learning.platabank.payeeservice.service;

import com.insight.learning.platabank.payeeservice.domain.Payee;
import com.insight.learning.platabank.payeeservice.repository.PayeeRepository;
import com.insight.learning.platabank.payeeservice.utils.PayeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayeeService {

    private PayeeRepository payeeRepository;

    public PayeeService(PayeeRepository payeeRepository){
        this.payeeRepository = payeeRepository;
    }

    public Optional<Payee> save(Payee payee) {
        return Optional.ofNullable(payeeRepository.save(payee));
    }

    public Payee findById(Long id) {
        return payeeRepository.findById(id).orElseThrow(() -> new PayeeNotFoundException(id));
    }

    public void deleteById(Long id){
        payeeRepository.deleteById(id);
    }


}
