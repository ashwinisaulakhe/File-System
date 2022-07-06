package com.filesystem.springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	 	    
	private static final String[] WHITE_LIST_URLS = {
			"/login",
			"/register",
			"/verifyRegistration",
			"/resendVerifyToken",
			"/resetPassword",
			"/savePassword",
			"/changePassword"
			
	};


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
		http
			.cors()
			.and()
			.csrf()
			.disable()
			.authorizeHttpRequests()
			.antMatchers(WHITE_LIST_URLS).permitAll();
		return http.build();
			
	}
	
}

