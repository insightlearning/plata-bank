package com.insight.learning.platabank.customerservice.controller;

import com.insight.learning.platabank.customerservice.JsonMapper;
import com.insight.learning.platabank.customerservice.domain.*;
import com.insight.learning.platabank.customerservice.dto.CustomerDTO;
import com.insight.learning.platabank.customerservice.mapper.CustomerMapper;
import com.insight.learning.platabank.customerservice.mapper.CustomerMapperImpl;
import com.insight.learning.platabank.customerservice.service.AccountServiceProxy;
import com.insight.learning.platabank.customerservice.service.CustomerService;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@WebMvcTest
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MvcResult mvcResult;

    private Customer customer;

    @MockBean
    private CustomerMapper customerMapper;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private AccountServiceProxy accountServiceProxy;


    @Test
    public void testCreateCustomer() throws Exception {

        givenCustomer();

        whenRequestToCreateCustomerIsMade();

        thanShouldReturnHttpStatusCodeCreated();

        thanShouldReturnCustomer();
    }
    @Test
    public void testGetAllCustomers() throws Exception {
        whenRequestToGetAllCustomerIsMade();

        thanShouldReturnHttpStatusCodeOk();

        thanShouldReturnCustomers();
    }

    @Test
    public void testActivateCustomer() throws Exception {
        Long id = 31212l;
        whenRequestToActivateCustomerIsMade(id);

        thanShouldReturnHttpStatusCodeNoContent();
    }

    @Test
    public void testDeactivateCustomer() throws Exception {
        Long id = 31212l;
        whenRequestToDeactivateCustomerIsMade(id);

        thanShouldReturnHttpStatusCodeNoContent();
    }

    @Test
    public void testFindCustomerById() throws Exception {
        Long id = 435058241l;

        whenRequestToFindCustomerIsMade(id);

        thanShouldReturnHttpStatusCodeOk();

        thanShouldReturnCustomer();
    }

    private void whenRequestToFindCustomerIsMade(Long id) throws Exception {
        Customer customer = givenCustomer();

        CustomerMapper customerMapperLocal = new CustomerMapperImpl();
        CustomerDTO customerDto = customerMapperLocal.toCustomerDTO(customer);

        given(customerService.findById(id)).willReturn(customer);
        given(customerMapper.toCustomerDTO(customer)).willReturn((customerDto));

        String uri = "/customer/"+id;
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc.perform(requestBuilder).andReturn();
    }


    private void thanShouldReturnHttpStatusCodeNoContent() {
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.NO_CONTENT.value(), status);
    }

    private void whenRequestToActivateCustomerIsMade(Long id) throws Exception {
        String uri = "/customer/activate/"+id;
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .patch(uri)
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc.perform(requestBuilder).andReturn();
    }

    private void whenRequestToDeactivateCustomerIsMade(Long id) throws Exception {
        String uri = "/customer/deactivate/"+id;
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .patch(uri)
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc.perform(requestBuilder).andReturn();
    }


    private void thanShouldReturnCustomers() throws IOException {
        String customerJsonResponse = mvcResult.getResponse().getContentAsString();
        List<Customer> customersResponse= JsonMapper.mapFromJsonList(customerJsonResponse,Customer.class);
        assertNotNull(customersResponse);
    }

    private void thanShouldReturnHttpStatusCodeOk() {
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
    }

    private void whenRequestToGetAllCustomerIsMade() throws Exception {
        ArrayList<Customer>  customers = new ArrayList();
        customers.add(givenCustomer());
        given(customerService.findAll()).willReturn(customers);
        String uri = "/customer";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(uri)
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc.perform(requestBuilder).andReturn();

    }
    private void thanShouldReturnCustomer() throws IOException {
        String customerJsonResponse = mvcResult.getResponse().getContentAsString();
        Customer customerResponse= JsonMapper.mapFromJson(customerJsonResponse,Customer.class);

        assertEquals(customer, customerResponse);
    }

    private void thanShouldReturnHttpStatusCodeCreated() {
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.CREATED.value(), status);
    }

    private void whenRequestToCreateCustomerIsMade() throws Exception {
        CustomerMapper customerMapperLocal = new CustomerMapperImpl();
        CustomerDTO customerDto = customerMapperLocal.toCustomerDTO(customer);
        String inputJson = JsonMapper.mapToJson(customer);
        String uri = "/customer";
        given(customerMapper.toCustomer(Mockito.any(CustomerDTO.class))).willReturn((customer));
        given(customerService.save(customer)).willReturn(Optional.of(customer));
        given(customerMapper.toCustomerDTO(customer)).willReturn((customerDto));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(uri)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON);

        mvcResult = mockMvc.perform(requestBuilder).andReturn();
    }

    private Customer givenCustomer() {
        customer = new Customer(435058241l, new Career(), new Address(), new ArrayList<ContactPhone>(),
                new Date(), Sex.MALE, "Joao Silva", "Maria Souza",
                "Marcus Silva Souza" );
        return customer;
    }







}