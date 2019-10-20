package com.insight.learning.platabank.customerservice.repository;

import com.insight.learning.platabank.customerservice.domain.Customer;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends Repository<Customer,Long> {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);

}
