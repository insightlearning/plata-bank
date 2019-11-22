package com.insight.learning.platabank.transferenceservice.service.impl;

import com.insight.learning.platabank.transferenceservice.domain.Account;
import com.insight.learning.platabank.transferenceservice.domain.Payee;
import com.insight.learning.platabank.transferenceservice.domain.Transference;
import com.insight.learning.platabank.transferenceservice.enumerator.TransferType;
import com.insight.learning.platabank.transferenceservice.repository.TransferenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class TEVTransferenceServiceImplTest {

    private TEVTransferenceServiceImpl tevTransferenceService;

    private Transference tevTransference;

    @MockBean
    private TransferenceRepository repository;

    @Test
    public void testTEVTransference(){

        given(repository.save(tevTransference)).willReturn(givenTransference());

        Optional<Transference> resultTEVTransference = tevTransferenceService.doTransference(tevTransference);

        assertEquals(TransferType.TEV, resultTEVTransference.get().getTransferType());

    }

    private Transference givenTransference() {
        return tevTransference;
    }

    @BeforeEach
    public void setUp(){
        tevTransferenceService = new TEVTransferenceServiceImpl(repository);

        tevTransference = new Transference();
        Account account = new Account();
        Payee payee = new Payee();

        tevTransference.setTransferType(TransferType.TEV);
        tevTransference.setTransferDate(LocalDateTime.now());
        tevTransference.setPayee(payee);
        tevTransference.setId(1l);
        tevTransference.setAmount(100.00);
        tevTransference.setAccount(account);
    }
}
