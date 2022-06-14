package com.filesystem.springapp.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filesystem.springapp.services.UserService;
import com.filesystem.springapp.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public String showRegistrationForm()
	{
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("registration") UserRegistrationDto registrationDto)
	{
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}