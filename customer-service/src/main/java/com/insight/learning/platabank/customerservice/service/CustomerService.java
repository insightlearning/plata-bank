package com.insight.learning.platabank.customerservice.service;

import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.domain.Status;
import com.insight.learning.platabank.customerservice.repository.CustomerRepository;
import com.insight.learning.platabank.customerservice.utils.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    public  CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> save(Customer customer){
        return Optional.ofNullable(customerRepository.save(customer));
    }

    public Customer findById(Long id){
            return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer activateCustomer(Long id) {
        Customer customer = findById(id);
        customer.setStatus(Status.ACTIVE);
        customerRepository.save(customer);
        return customer;
    }

    public void deactivateCustomer(Long id){
        Customer customer = findById(id);
        customer.setStatus(Status.INACTIVE);
        customerRepository.save(customer);
    }


}
