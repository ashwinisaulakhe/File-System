package com.filesystem.springapp.config;

import java.util.Collections;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()  
                .paths(PathSelectors.any())
              .apis(RequestHandlerSelectors.basePackage("com.filesystem.springapp"))
              .build()
        	.apiInfo(apiInfo());
    }

	private ApiInfo apiInfo() {
		return new ApiInfo(
			      "My REST API", 
			      "Some custom description of API.", 
			      "API TOS", 
			      "Terms of service", 
			      new Contact("John Doe", "www.example.com", "myeaddress@company.com"), 
			      "License of API", "API license URL", Collections.emptyList());
	}

}