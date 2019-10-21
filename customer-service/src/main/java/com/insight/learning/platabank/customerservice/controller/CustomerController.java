package com.insight.learning.platabank.customerservice.controller;

import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/activate/{id}")
    public void activateCustomer(@PathVariable Long id){
        customerService.activateCustomer(id);
    }

    @GetMapping("/deactivate/{id}")
    public void deactivateCustomer(@PathVariable Long id){
        customerService.deactivateCustomer(id);
    }
}
