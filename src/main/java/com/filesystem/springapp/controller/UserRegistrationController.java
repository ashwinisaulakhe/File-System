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

import com.filesystem.springapp.entities.Registration;
import com.filesystem.springapp.repositories.UserRepository;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

	 private final UserRepository userRepository;

	    

	    public UserRegistrationController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

		@GetMapping
		public List<Registration> getRegistration() {
	        return userRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Registration getRegistration(@PathVariable Long id) {
	        return userRepository.findById(id).orElseThrow(RuntimeException::new);
	    }

	    @PostMapping
	    public ResponseEntity createRegistration(@RequestBody Registration registration) throws URISyntaxException {
	    	Registration savedClient = userRepository.save(registration);
	        return ResponseEntity.created(new URI("/registration/" + savedClient.getId())).body(savedClient);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity updateRegistration(@PathVariable Long id, @RequestBody Registration client) {
	    	Registration currentRegistration = userRepository.findById(id).orElseThrow(RuntimeException::new);
	    	currentRegistration.setUserName(currentRegistration.getUserName());
	    	currentRegistration.setUser_mailid(currentRegistration.getUser_mailid());
	    	currentRegistration.setUser_passwd(currentRegistration.getUser_passwd());
	    	currentRegistration.setUser_phno(currentRegistration.getUser_phno());
	    	currentRegistration =userRepository.save(client);

	        return ResponseEntity.ok(currentRegistration);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity deleteRegistration(@PathVariable Long id) {
	    	userRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
	}
