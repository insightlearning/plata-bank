package com.insight.learning.platabank.accountservice.repository;

import com.insight.learning.platabank.accountservice.model.Account;
import com.insight.learning.platabank.accountservice.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @author padovese
 * @since 28/10/2019
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void PersistAccountTest(){
        var customer = new Customer();
        customer.setId(16416L);
        customer.setFullName("Bruno Padovese");

        var account = new Account(customer);
        entityManager.persist(account);
        entityManager.flush();

        Optional<Account> persistedAccount = accountRepository.findById(account.getNumber());
        int persistedAccountNumber = persistedAccount.map(a -> a.getNumber()).orElseThrow(RuntimeException::new);

        assertEquals(account.getNumber(), persistedAccountNumber);
    }

}
