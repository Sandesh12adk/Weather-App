package com.example.minor.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.minor.project.repo")
@EntityScan("com.example.minor.project.model")
@EnableJpaAuditing
public class MinorProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(MinorProjectApplication.class, args);
	}

}
