package com.insight.learning.platabank.transferenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TransferenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferenceServiceApplication.class, args);
	}

}
