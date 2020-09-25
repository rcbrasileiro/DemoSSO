package com.rcbrasileiro.demosso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSsoApplication.class, args);
	}

}
