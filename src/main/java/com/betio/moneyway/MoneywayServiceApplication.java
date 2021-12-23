package com.betio.moneyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MoneywayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneywayServiceApplication.class, args);
	}

}
