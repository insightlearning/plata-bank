package com.insight.learning.platabank.customerservice.controller;

import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.dto.CustomerDTO;
import com.insight.learning.platabank.customerservice.mapper.CustomerMapper;
import com.insight.learning.platabank.customerservice.service.AccountServiceProxy;
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

    private AccountServiceProxy accountServiceProxy;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper, AccountServiceProxy accountServiceProxy) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.accountServiceProxy = accountServiceProxy;
    }

    @GetMapping
    public List<CustomerDTO> findAll(){
        List<Customer> customers= customerService.findAll();
        return customers.stream()
                .map(customer -> customerMapper.toCustomerDTO(customer))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable Long id){
        return customerMapper.toCustomerDTO(customerService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO create(@RequestBody CustomerDTO customerDto){
        Customer customer = customerService.save(customerMapper.toCustomer(customerDto)).get();
        return customerMapper.toCustomerDTO(customer);
    }


    @PatchMapping("/activate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateCustomer(@PathVariable Long id){
       Customer customer = customerService.activateCustomer(id);
       createAccount(customer);

    }

    private void createAccount(Customer customer) {
        accountServiceProxy.createAccount(customer);
    }

    @PatchMapping("/deactivate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateCustomer(@PathVariable Long id){
        customerService.deactivateCustomer(id);
    }


}
