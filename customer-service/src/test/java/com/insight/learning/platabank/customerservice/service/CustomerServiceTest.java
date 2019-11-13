package com.insight.learning.platabank.customerservice.service;

import com.insight.learning.platabank.customerservice.domain.*;
import com.insight.learning.platabank.customerservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class CustomerServiceTest {

    @MockBean
    CustomerRepository customerRepository;

    CustomerService customerService;

    @BeforeEach
    public void setUp(){
        customerService = new CustomerService(customerRepository);
    }

    @Test
    public void testFindAllCustomers(){
        whenFindAll();
        thenShouldReturnAllCostumers();
    }

    @Test
    public void testFindCustomerById(){
        Customer customer = givenCustomer();
        whenCustomerIsFoundById(435058241l);
        thenShouldReturnCostumer(customer.getId());
    }

    @Test
    public void testCreateCustomer(){
        Customer customer = givenCustomer();
        whenCustomerIsCreated(customer);
        thenShouldReturnCostumer(customer);
    }


    private void whenCustomerIsCreated(Customer customer) {
        given(customerRepository.save(customer)).willReturn(customer);
    }

    private void thenShouldReturnCostumer(Long id) {
        assertNotNull(customerService.findById(id));
    }

    private void thenShouldReturnCostumer(Customer customer) {
        assertNotNull(customerService.save(customer));
    }

    private void whenCustomerIsFoundById(Long id) {
        given(customerRepository.findById(id)).willReturn(Optional.of(givenCustomer()));
    }

    private void whenFindAll() {
        ArrayList<Customer> customers = new ArrayList();
        customers.add(givenCustomer());
        given(customerRepository.findAll()).willReturn(customers);
    }

    private void thenShouldReturnAllCostumers() {
        assertNotNull(customerService.findAll());
    }


    private Customer givenCustomer() {
        Customer customer = new Customer(435058241l, new Career(), new Address(), new ArrayList<ContactPhone>(),
                new Date(), Sex.MALE, "Joao Silva", "Maria Souza",
                "Marcus Silva Souza" );
        return customer;
    }
}