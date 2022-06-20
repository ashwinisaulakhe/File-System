package com.filesystem.springapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filesystem.springapp.entities.UserRegistration;
import com.filesystem.springapp.repositories.UserRegRepository;


@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

	 private final UserRegRepository userRegRepository;


	    public UserRegistrationController(UserRegRepository userRegRepository) {
		super();
		this.userRegRepository = userRegRepository;
	}

		@GetMapping
		public List<UserRegistration> getRegistration() {
	        return userRegRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public UserRegistration getRegistration(@PathVariable Long id) {
	        return userRegRepository.findById(id).orElseThrow(RuntimeException::new);
	    }

	    @PostMapping
	    public ResponseEntity createRegistration(@RequestBody UserRegistration registration) throws URISyntaxException {
	    	UserRegistration savedRegistration = userRegRepository.save(registration);
	        return ResponseEntity.created(new URI("/registration/" + savedRegistration.getId())).body(savedRegistration);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity updateRegistration(@PathVariable Long id, @RequestBody UserRegistration registration) {
	    	UserRegistration currentRegistration = userRegRepository.findById(id).orElseThrow(RuntimeException::new);
	    	currentRegistration.setUserName(currentRegistration.getUserName());
	    	currentRegistration.setUser_mailid(currentRegistration.getUser_mailid());
	    	currentRegistration.setUser_passwd(currentRegistration.getUser_passwd());
	    	currentRegistration.setUser_phno(currentRegistration.getUser_phno());
	    	currentRegistration =userRegRepository.save(registration);

	        return ResponseEntity.ok(currentRegistration);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity deleteRegistration(@PathVariable Long id) {
	    	userRegRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
	}
