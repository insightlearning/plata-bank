package com.insight.learning.platabank.payeeservice.controller;

import com.insight.learning.platabank.payeeservice.JsonMapper;
import com.insight.learning.platabank.payeeservice.domain.Account;
import com.insight.learning.platabank.payeeservice.domain.Bank;
import com.insight.learning.platabank.payeeservice.domain.Payee;
import com.insight.learning.platabank.payeeservice.dto.PayeeDTO;
import com.insight.learning.platabank.payeeservice.mapper.PayeeMapper;
import com.insight.learning.platabank.payeeservice.mapper.PayeeMapperImpl;
import com.insight.learning.platabank.payeeservice.service.PayeeService;
import com.insight.learning.platabank.payeeservice.utils.PayeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@WebMvcTest
class PayeeControllerTest {

    @Autowired
    private  MockMvc mockMvc;

    private MvcResult mvcResult;

    @MockBean
    private PayeeService payeeService;

    @MockBean
    private PayeeMapper payeeMapper;

    private Payee payee;


    @Test
    void testCreatePayee() throws Exception {
        Payee payee = givenPayee();

        whenRequestToCreatePayeeIsMade(payee);

        thanShouldReturnHttpStatusCodeCreated();

        thanShouldReturnPayee(payee);

    }

    @Test
    void testFindPayeeById() throws Exception {
        Long id = 435058241L;

        whenRequestToFindPayeeIsMade(id);

        thanShouldReturnHttpStatusCodeOk();

        thanShouldReturnPayee();
    }

    @Test
    void testPayeeNotFound() throws Exception {
        Long id = 435058L;

        whenRequestToFindPayeeIsMade(id);

        thanShouldReturnHttpStatusCodeNotFound();
    }

    private void thanShouldReturnHttpStatusCodeNotFound() {
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.NOT_FOUND.value(), status);
    }

    private void thanShouldReturnPayee() throws IOException {
        String payeeJsonResponse = mvcResult.getResponse().getContentAsString();
        Payee payeeResponse= JsonMapper.mapFromJson(payeeJsonResponse,Payee.class);

        assertEquals(getPayee(), payeeResponse);
    }

    private void thanShouldReturnHttpStatusCodeOk() {
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }
    private void whenRequestToFindPayeeIsMade(Long id) throws Exception {
        Payee payee = givenPayee();
        PayeeMapper payeeMapperLocal = new PayeeMapperImpl();
        PayeeDTO payeeDTO = payeeMapperLocal.toPayeeDTO(payee);

        String uri = "/payee/"+id;
        if(payee.getId().equals(id)) {
            given(payeeService.findById(id)).willReturn((payee));
            given(payeeMapper.toPayeeDTO(payee)).willReturn((payeeDTO));
        }else
            given(payeeService.findById(id)).willThrow(PayeeNotFoundException.class);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc.perform(requestBuilder).andReturn();
    }

    private void whenRequestToCreatePayeeIsMade(Payee payee) throws Exception {
        PayeeMapper payeeMapperLocal = new PayeeMapperImpl();
        PayeeDTO payeeDTO = payeeMapperLocal.toPayeeDTO(payee);

        String inputJson = JsonMapper.mapToJson(payee);
        String uri = "/payee";
        given(payeeMapper.toPayee(Mockito.any(PayeeDTO.class))).willReturn((payee));
        given(payeeService.save(payee)).willReturn(Optional.of(payee));

        given(payeeMapper.toPayeeDTO(payee)).willReturn((payeeDTO));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(uri)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc.perform(requestBuilder).andReturn();

    }

    private void thanShouldReturnHttpStatusCodeCreated() {
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.CREATED.value(), status);
    }

    private void thanShouldReturnPayee(Payee payee) throws IOException {
        String payeeJsonResponse = mvcResult.getResponse().getContentAsString();
        Payee payeeResponse= JsonMapper.mapFromJson(payeeJsonResponse,Payee.class);

        assertEquals(payee, payeeResponse);
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

        setPayee(payee);

        return payee;
    }

    private void setPayee(Payee payee) {
        this.payee = payee;
    }

    private Payee getPayee(){
        return payee;
    }

    private Account getAccount() {
        Account account = new Account();
        account.setAgency(10001);
        account.setDac(111);
        account.setBank(getBank());
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