package com.insight.learning.platabank.customerservice.repository;

import com.insight.learning.platabank.customerservice.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testPersistingCustomerInTheDatabase() {
        Customer customer = givenCustomer();

        whenCustomerIsPersisted(customer);

        thenCustomerShouldBeFoundById(customer);
    }

    private void whenCustomerIsPersisted(Customer customer) {
        entityManager.persist(customer);
        entityManager.flush();
    }
    private void thenCustomerShouldBeFoundById(Customer customer) {
        Optional<Customer> persistedAccount = customerRepository.findById(customer.getId());
        long persistedCustomerId = persistedAccount.map(a -> a.getId()).orElseThrow(RuntimeException::new);

        assertEquals(customer.getId(), persistedCustomerId);
    }

    private Customer givenCustomer() {
        Customer customer = new Customer(435058241l, new Career(), new Address(), new ArrayList<ContactPhone>(),
                new Date(), Sex.MALE, "Joao Silva", "Maria Souza",
                "Marcus Silva Souza" );
        return customer;
    }
}