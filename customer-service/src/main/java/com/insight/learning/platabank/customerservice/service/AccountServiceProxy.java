package com.insight.learning.platabank.customerservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="zuul-api-gateway-server")
@RibbonClient(name="account-service")
public interface AccountServiceProxy {


}
