package com.eraykosterelioglu.start_spring_jpa.starter;

import com.eraykosterelioglu.start_spring_jpa.configuration.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.eraykosterelioglu.start_spring_jpa"})
@ComponentScan(basePackages ={"com.eraykosterelioglu.start_spring_jpa"} )
@EnableJpaRepositories(basePackages = {"com.eraykosterelioglu.start_spring_jpa"})
@PropertySource(value = "classpath:app.properties")
@EnableConfigurationProperties(value = ConfigProperties.class)
public class StartSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartSpringJpaApplication.class, args);
	}

}
