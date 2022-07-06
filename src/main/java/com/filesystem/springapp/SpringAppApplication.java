package com.filesystem.springapp;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.filesystem.springapp.services.FilesStorageService;

@Configuration
@EntityScan(basePackages = {"com.filesystem.sprinapp.entities"})
@ComponentScan(basePackages = {"com.filesystem.sprinapp"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackages="com.filesystem.springapp.repositories.UserEntityRepository",entityManagerFactoryRef = "sessionFactory")
@SpringBootApplication(scanBasePackages={ "com.filesystem.sprinapp" })
public class SpringAppApplication implements CommandLineRunner {
	
	 @Resource
	  FilesStorageService storageService;
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

	 @Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }
}
