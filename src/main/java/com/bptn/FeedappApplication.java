package com.bptn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FeedappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedappApplication.class, args);
	}
	
	
	// sprin executes the method, the method returns a rest temaple object
	// and thansk to the @Bean annotation , the restTemplate object is allocated in the spring IOC container
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build(); 
	}

}
