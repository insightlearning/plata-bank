package com.insight.learning.platabank.transferenceservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insight.learning.platabank.transferenceservice.dto.TransferenceDTO;
import com.insight.learning.platabank.transferenceservice.service.TransferenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TransferenceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TransferenceService transferenceService;

    private MvcResult mvcResult;

    TransferenceDTO docTransference;

    @Test
    public void mustTransfer() throws Exception {

        RequestBuilder requestBuilder = post("/transference")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(docTransference))
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

    }

    @BeforeEach
    public void setup(){
        docTransference = new TransferenceDTO();
    }

}
