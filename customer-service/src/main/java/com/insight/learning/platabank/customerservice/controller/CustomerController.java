package com.insight.learning.platabank.customerservice.controller;

import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id){
        return customerRepository.findById(id);
    }
}
