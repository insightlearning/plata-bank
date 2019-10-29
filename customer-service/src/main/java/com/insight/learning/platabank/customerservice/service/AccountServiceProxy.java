package com.insight.learning.platabank.customerservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="zuul-api-gateway-server")
@RibbonClient(name="account-service")
public interface AccountServiceProxy {


}
