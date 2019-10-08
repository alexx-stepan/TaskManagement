package com.alexxstepan.taskmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {WebMvcAutoConfiguration.class})
//@EntityScan("com.alexxstepan.taskmanagement.entities")
//@EnableJpaRepositories(basePackages = {"com.alexxstepan.taskmanagement.dao.repositories"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
