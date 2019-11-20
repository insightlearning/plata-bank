package com.insight.learning.platabank.payeeservice.repository;

import com.insight.learning.platabank.payeeservice.domain.Account;
import com.insight.learning.platabank.payeeservice.domain.Bank;
import com.insight.learning.platabank.payeeservice.domain.Payee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void testFindAllPayees(){
        List<Payee> payees = givenPayees();

        whenPayeesIsPersisted(payees);

        thenPayeesShouldBeFound(payees);

    }

    private void whenPayeeIsPersisted(Payee payee) {
        entityManager.persist(payee);
        entityManager.flush();
    }

    private void whenPayeesIsPersisted(List<Payee> payees) {
        payees.stream().forEach(p -> whenPayeeIsPersisted(p));
    }

    private void thenPayeeShouldBeFoundById(Payee payee) {
        Optional<Payee> payeePersisted = payeeRepository.findById(payee.getId());
        assertEquals(payeePersisted.get().getId(), payee.getId());

    }

    private void thenPayeesShouldBeFound(List<Payee> payees) {
        List<Payee> payeesPersisted = payeeRepository.findAll();
        assertTrue(payees.containsAll(payeesPersisted));
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

    private List<Payee> givenPayees() {
        Payee payee1 = givenPayee();

        Payee payee2 = givenPayee();
        payee2.setId(2222332l);

        List<Payee> payees = new ArrayList<>();
        payees.add(payee1);
        payees.add(payee2);

        return payees;
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