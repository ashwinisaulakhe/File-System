package com.filesystem.springapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filesystem.springapp.entities.Registration;
import com.filesystem.springapp.services.RegistrationService;

@RestController
public class MyController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/sample")
	public String sampleFun()
	{
		return "this is registration page";
	}
	
	@GetMapping("/registration")
	public List<Registration> getRegistration()
	{
		return this.registrationService.getRegistration();
	}
	
}
