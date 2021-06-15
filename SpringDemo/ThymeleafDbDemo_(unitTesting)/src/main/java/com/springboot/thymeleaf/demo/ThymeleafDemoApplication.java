package com.springboot.thymeleaf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//To discard the security auto-configuration and add our own configuration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ThymeleafDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafDemoApplication.class, args);
	}

}

//To discard the security auto-configuration and add our own configuration
//Or we can add some configuration into the application.properties file:
//spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration