package com.insight.learning.platabank.customerservice.controller;

import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.dto.CustomerDto;
import com.insight.learning.platabank.customerservice.mapper.CustomerMapper;
import com.insight.learning.platabank.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    @ResponseBody
    public List<CustomerDto> findAll(){
        List<Customer> customers= customerService.findAll();
        return customers.stream()
                .map(customer -> customerMapper.toCustomerDto(customer))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Long id){
        return customerMapper.toCustomerDto(customerService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto create(@RequestBody CustomerDto customerDto){
        Customer customer = customerService.save(customerMapper.toCustomer(customerDto)).get();
        return customerMapper.toCustomerDto(customer);
    }

    @PatchMapping("/activate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateCustomer(@PathVariable Long id){
        customerService.activateCustomer(id);
    }

    @PatchMapping("/deactivate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateCustomer(@PathVariable Long id){
        customerService.deactivateCustomer(id);
    }
}
