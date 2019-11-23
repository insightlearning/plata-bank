package com.insight.learning.platabank.payeeservice.repository;

import com.insight.learning.platabank.payeeservice.domain.Account;
import com.insight.learning.platabank.payeeservice.domain.Bank;
import com.insight.learning.platabank.payeeservice.domain.Payee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PayeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PayeeRepository payeeRepository;

    @Test
    void testPersistingPayee(){
        Payee payee = givenPayee();

        whenPayeeIsPersisted(payee);

        thenPayeeShouldBeFoundById(payee);
    }


    @Test
    void testDeletePayeeById(){
        Payee payee = givenPayee();

        whenPayeeIsPersisted(payee);
        whenPayeeIsDeleted(payee);

        thenPayeeShouldNotBeFoundById(payee);
    }

    private void whenPayeeIsPersisted(Payee payee) {
        entityManager.persist(payee);
        entityManager.flush();
    }

    private void whenPayeeIsDeleted(Payee payee) {
        entityManager.remove(payee);
        entityManager.flush();
    }


    private void thenPayeeShouldBeFoundById(Payee payee) {
        Optional<Payee> payeePersisted = payeeRepository.findById(payee.getId());
        assertEquals(payeePersisted.get().getId(), payee.getId());

    }
    private void thenPayeeShouldNotBeFoundById(Payee payee) {
        Optional<Payee> payeePersisted = payeeRepository.findById(payee.getId());
        assertEquals(payeePersisted.isEmpty(), payeePersisted.isEmpty());

    }

    private Payee givenPayee() {
        Payee payee = new Payee();
        payee.setId(4054543431l);
        payee.setEmail("mosby@gmail.com");
        payee.setFullName("Teodore Mosby");
        payee.setNickName("Ted");

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(getAccount());

        payee.setAccount(accounts);

        return payee;
    }

    private Account getAccount() {
        Account account = new Account();
        account.setAgency(10001);
        account.setDac(111);
        account.setBank(getBank());;
        return account;
    }

    private Bank getBank() {
        Bank bank = new Bank();
        bank.setCode(111);
        bank.setISPB(2121);
        bank.setName("Plata bank ");
        bank.setNickName("Plata");
        return bank;
    }







}