package com.filesystem.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filesystem.springapp.entities.UserRegistration;
import com.filesystem.springapp.repositories.UserRegRepository;
import com.filesystem.springapp.services.UserRegService;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	 private UserRegService userRegService;
	
	 private final UserRegRepository userRegRepository;

	public UserRegistrationController(UserRegRepository userRegRepository) {
		super();
		this.userRegRepository = userRegRepository;
	}

	    @GetMapping("/registration")
	    public String register(final Model model){
	        model.addAttribute("userRegistration", new UserRegistration());
	        return "account/register";
	    }

	  //  @PutMapping("/{id}")
	   // public ResponseEntity updateRegistration(@PathVariable Long id, @RequestBody UserRegistration registration) {
	   // 	UserRegistration currentRegistration = userRegRepository.findById(id).orElseThrow(RuntimeException::new);
	   // 	currentRegistration.setUserName(currentRegistration.getUserName());
	   // 	currentRegistration.setUser_mailid(currentRegistration.getUser_mailid());
	   // 	currentRegistration.setUser_passwd(currentRegistration.getUser_passwd());
	   // 	currentRegistration.setUser_phno(currentRegistration.getUser_phno());
	   // 	currentRegistration.setConfirmPass(currentRegistration.getConfirmPass());
	   // 	currentRegistration =userRegRepository.save(registration);

	    //    return ResponseEntity.ok(currentRegistration);
	    // }
	    
	    @PostMapping("/registration")
	    public String userRegistration(final @Validated  UserRegistration userRegistration, final BindingResult bindingResult, final Model model, String REDIRECT){
	        if(bindingResult.hasErrors()){
	            model.addAttribute("registrationForm", userRegistration);
	            return "account/register";
	        }
	        
	        try {
	            
	        	userRegService.register(userRegistration);
	         }
	        catch (UserAlreadyExistException e){
	            bindingResult.rejectValue("email", "userRegistration.email","An account already exists for this email.");
	            model.addAttribute("registrationForm", userRegistration);
	            return "account/register";
	        }
	     
		
			return REDIRECT+"/starter";
	    }

	   
	}
