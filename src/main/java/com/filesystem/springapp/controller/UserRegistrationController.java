package com.filesystem.springapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.filesystem.springapp.dto.UserData;
import com.filesystem.springapp.entities.UserRegistration;
import com.filesystem.springapp.serviceImpl.UserAlreadyExistsException;
import com.filesystem.springapp.serviceImpl.UserRegService;

@Controller
public class UserRegistrationController {

	private static final String REDIRECT = null;
	private Model model;

	@Autowired
	private UserRegService userRegService;
	
	
	@GetMapping("/register")
	public String register(final Model model) {
		model.addAttribute("userData", new UserData());
		return "home/register";
	}
	
	@PostMapping
	public String userRegistrations(final @Valid UserData userData,final BindingResult bindingResult,final Model model)
	{
		if(bindingResult.hasErrors()) {
			model.addAttribute("UerData",userData);
			return "home/register";
		}
		try
		{
			userRegService.register(userData);
		}
		catch(UserAlreadyExistsException e){
			bindingResult.rejectValue("userMailId", "userData.userMailId", "An account already Exist for this emailId");
			model.addAttribute("registrationForm",userData);
			return "home/register";
		}
		return REDIRECT + "home/register";
	}
}
