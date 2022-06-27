package com.filesystem.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration

//@ComponentScan({ "com.filesystem.sprinapp.services" })
//@EntityScan(basePackages = {"com.filesystem.sprinapp.entities"})
//@ComponentScan(basePackages = {"com.filesystem.sprinapp"})

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackages="com.filesystem.springapp.repositories.UserEntityRepository",entityManagerFactoryRef = "sessionFactory")
@SpringBootApplication(scanBasePackages={ "com.filesystem.sprinapp" })
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

}
