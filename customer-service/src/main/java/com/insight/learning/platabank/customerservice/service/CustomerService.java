package com.insight.learning.platabank.customerservice.service;

import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.domain.Status;
import com.insight.learning.platabank.customerservice.repository.CustomerRepository;
import com.insight.learning.platabank.customerservice.utils.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Optional<Customer> getCustomer(Long id){
        return customerRepository.findById(id);
    }

    public void activateCustomer(Long id) {
        getCustomer(id).map((Customer customer) -> {
            customer.setStatus(Status.ACTIVE);
            customerRepository.save(customer);
            return customer;
        }).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public void deactivateCustomer(Long id){
        getCustomer(id).map((Customer customer) -> {
            customer.setStatus(Status.INACTIVE);
            customerRepository.save(customer);
            return customer;
        }).orElseThrow(() -> new CustomerNotFoundException(id));
    }


}
