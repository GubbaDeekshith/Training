package com.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(title = "Employee Service Api"))

public class EmployeeapplicationApplication {
	
	@Bean
	@LoadBalanced
	RestTemplate resttemp(){
		HttpComponentsClientHttpRequestFactory client = new HttpComponentsClientHttpRequestFactory();
		client.setConnectTimeout(3000);
		return new RestTemplate();
	}

	public static void main(String[] args) {
		
		SpringApplication.run(EmployeeapplicationApplication.class, args);
		
	}

}
