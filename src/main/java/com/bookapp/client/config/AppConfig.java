package com.bookapp.client.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import com.bookapp.client.exception.CustomeErrorResopnseHandler;

@Configuration
public class AppConfig {
	
	
	@Bean(name = "restTemplate")
	public RestTemplate restTemplate() {
		
		//return new RestTemplate();
		
		return new  RestTemplateBuilder()
				.errorHandler(new CustomeErrorResopnseHandler())
				
				.build();
	}
	
	@Bean
	public RestClient restClient() {
		
		
		return RestClient.builder().baseUrl("http://localhost:9091")
				
				.build();
		
	}
	

}
