package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient deprecated after STS 3.0
public class EmployeeMicroserviceApplication {
//     @Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
     
//     @Bean
//     public WebClient webClient() {
//    	 return WebClient.builder().build();
//     }
	public static void main(String[] args) {
		SpringApplication.run(EmployeeMicroserviceApplication.class, args);
	}

}
