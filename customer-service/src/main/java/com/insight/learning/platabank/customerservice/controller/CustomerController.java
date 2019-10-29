package com.insight.learning.platabank.customerservice.controller;

import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.dto.CustomerDto;
import com.insight.learning.platabank.customerservice.mapper.CustomerMapper;
import com.insight.learning.platabank.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerDto customerDto){
        customerService.save(customerMapper.toCustomer(customerDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDto);
    }

    @PatchMapping("/activate/{id}")
    public ResponseEntity activateCustomer(@PathVariable Long id){
        customerService.activateCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity deactivateCustomer(@PathVariable Long id){
        customerService.deactivateCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
