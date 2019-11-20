package com.insight.learning.platabank.payeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PayeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayeeServiceApplication.class, args);
	}

}
