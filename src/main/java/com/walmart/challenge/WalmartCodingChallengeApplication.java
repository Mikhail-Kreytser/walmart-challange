package com.walmart.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com")
public class WalmartCodingChallengeApplication {
	public static void main(String[] args) {
		SpringApplication.run(WalmartCodingChallengeApplication.class, args);
	}

}
