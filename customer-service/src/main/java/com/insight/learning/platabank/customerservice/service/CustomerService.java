package com.insight.learning.platabank.customerservice.service;

import com.insight.learning.platabank.customerservice.domain.Customer;
import com.insight.learning.platabank.customerservice.domain.Status;
import com.insight.learning.platabank.customerservice.repository.CustomerRepository;
import com.insight.learning.platabank.customerservice.utils.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomer(Long id){
        return customerRepository.findById(id);
    }

    public void activateCustomer(Long id) {
        getCustomer(id).map((Customer customer) -> {
            customer.setStatus(Status.ACTIVE);
            customerRepository.save(customer);
            return customer;
        }).orElseThrow(NoContentException::new);
    }

    public void deactivateCustomer(Long id){
        getCustomer(id).map((Customer customer) -> {
            customer.setStatus(Status.INACTIVE);
            customerRepository.save(customer);
            return customer;
        }).orElseThrow(NoContentException::new);
    }


}
