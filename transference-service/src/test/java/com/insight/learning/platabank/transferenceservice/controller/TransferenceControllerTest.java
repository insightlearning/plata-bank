package com.insight.learning.platabank.transferenceservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insight.learning.platabank.transferenceservice.builders.*;
import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;
import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import com.insight.learning.platabank.transferenceservice.mapper.TransferenceMapperImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TransferenceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TransferenceMapperImpl transferenceMapper;

    private MvcResult mvcResult;

    Account sourceAccount;

    Payee payee;

    @Test
    public void mustTransferDocToday() throws Exception {
        TransferenceDTO docTransference = transferenceMapper.toTransferenceDTO(TransferenceBuilder
                .oneTransference()
                .fromAccount(sourceAccount)
                .toPayee(payee)
                .ofType(TransferType.DOC)
                .ammountValue(100.00)
                .atDate(LocalDateTime.now())
                .transference());

        RequestBuilder requestBuilder = post("/transference")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(docTransference))
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        Assert.assertNotNull(mvcResult);
    }

    @Before
    public void setup(){
        sourceAccount = AccountBuilder
                .oneAccount()
                .withAgency(1500)
                .withAccount(02345)
                .withDac(2)
                .typeAccount("Conta Corrente")
                .account();

        payee = PayeeBuilder
                .onePayee()
                .yourName("Kaique")
                .account(1324)
                .withCpf("4353453454")
                .payee();
    }

}
