package com.eraykosterelioglu.start_spring_jpa.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.eraykosterelioglu.start_spring_jpa"})
@ComponentScan(basePackages ={"com.eraykosterelioglu.start_spring_jpa"} )
@EnableJpaRepositories(basePackages = {"com.eraykosterelioglu.start_spring_jpa"})
public class StartSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartSpringJpaApplication.class, args);
	}

}
