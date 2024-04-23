package com.bookapp.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bookapp.*")
public class BookappClientApplication {

	public static void main(String[] args) {
		
	
		SpringApplication.run(BookappClientApplication.class, args);
	}
}
