package com.alexxstepan.taskmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EntityScan("com.alexxstepan.taskmanagement.entities")
@EnableJpaRepositories(basePackages = {"com.alexxstepan.taskmanagement.dao.repositories"})
@SpringBootApplication()
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
