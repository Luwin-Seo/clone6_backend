package com.example.clone6_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Clone6BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Clone6BackendApplication.class, args);
	}

}
