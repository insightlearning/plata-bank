package com.insight.learning.platabank.customerservice.service;

import com.insight.learning.platabank.customerservice.domain.Customer;
import feign.Headers;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="zuul-api-gateway-server")
@RibbonClient(name="account-service")
public interface AccountServiceProxy {


    @PostMapping("/account-service/account/create")
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    public void createAccount(Customer customer);
}
