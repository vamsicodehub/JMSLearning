package com.springrabbitmq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.springmongodb.*")
@ComponentScan(basePackages = { "com", "com.springsms.*", "com.springcamel.*" })
public class SpringrabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrabbitmqApplication.class, args);
	}

}
