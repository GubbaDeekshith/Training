package com.example.departmentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class DepartmentServiceWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceWithJpaApplication.class, args);
	}

}
