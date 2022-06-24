package com.filesystem.springapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filesystem.springapp.dao.UserData;
import com.filesystem.springapp.serviceImpl.UserEntityService;

@RestController
@RequestMapping("/register")
public class RegistrationController {


	@Autowired
    private UserEntityService userEntityService;
	

    @GetMapping("/register")
    public String register(final Model model){
        model.addAttribute("userData", new UserData());
        return "account/register";
    }

    @PostMapping("/register")
    public String userRegistration(final @Valid  UserData userData, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationForm", userData);
            return "account/register";
        }
        try {
            userEntityService.register(userData);
        }catch (UserAlreadyExistException e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
            model.addAttribute("registrationForm", userData);
            return "account/register";
        }
      
        return REDIRECT+"/starter";
    }
}
