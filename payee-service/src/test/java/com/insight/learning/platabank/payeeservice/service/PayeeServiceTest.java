package com.insight.learning.platabank.payeeservice.service;


import com.insight.learning.platabank.payeeservice.domain.Account;
import com.insight.learning.platabank.payeeservice.domain.Bank;
import com.insight.learning.platabank.payeeservice.domain.Payee;
import com.insight.learning.platabank.payeeservice.repository.PayeeRepository;
import com.insight.learning.platabank.payeeservice.utils.PayeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;


@SpringBootTest
class PayeeServiceTest {

    @MockBean
    private PayeeRepository payeeRepository;

    private PayeeService payeeService;

    @BeforeEach
    void setUp(){
        payeeService = new PayeeService(payeeRepository);
    }

    @Test
    void testCreatePayee(){
        Payee payee = givenPayee();
        
        whenPayeeIsCreated(payee);

        thanServiceShouldReturnPayeeCreated(payee);
    }

    @Test
    void testFindPayeeById(){

        Payee payee = givenPayee();

        whenPayeeIsFoundById(payee.getId());

        thanServiceShouldReturnPayee(payee);
    }

    @Test
    void testPayeeNotFound(){

        long invalidId = 1111L;
        whenPayeeIsNotFounddById(invalidId);

        thanServiceShouldThrowsPayeeNotFoundException(invalidId);

    }

    private void whenPayeeIsCreated(Payee payee) {

        given(payeeRepository.save(payee)).willReturn(givenPayee());
    }

    private void thanServiceShouldThrowsPayeeNotFoundException(Long invalidId) {

        assertThrows(PayeeNotFoundException.class, () -> payeeService.findById(invalidId));
    }

    private void whenPayeeIsNotFounddById(Long id){

        given(payeeRepository.findById(id)).willReturn(Optional.empty());

    }
    private void thanServiceShouldReturnPayee(Payee payee) {

        Payee payeeFound = payeeService.findById(payee.getId());

        assertEquals(payeeFound, payee);
    }
    private void thanServiceShouldReturnPayeeCreated(Payee payee) {

        Payee payeeFound = payeeService.save(payee);

        assertEquals(payeeFound, payee);
    }


    private void whenPayeeIsFoundById(Long id) {
        given(payeeRepository.findById(id)).willReturn(java.util.Optional.of(givenPayee()));
    }

    private Payee givenPayee() {
        Payee payee = new Payee();
        payee.setId(4054543431L);
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