package com.filesystem.springapp.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filesystem.springapp.entities.User;
import com.filesystem.springapp.repositories.UserRepository;


@Controller
@RequestMapping("/login")
public class UserController {

	private UserRepository loginRepository;

	public UserController(UserRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}
	
	@GetMapping("/index")
	public String getHome() { 
	return "/index";
    }
	
	@GetMapping("/login")
	public String login() { 
	return "/login";
    }
	
	@GetMapping("/logout")
	public String logout() { 
	return "/logout";
    }
	  
	@GetMapping
	public List<User> getUserLogin() {
        return loginRepository.findAll();
    }
	
	  @GetMapping("/{id}")
	    public User getUserLogin(@PathVariable Long id) {
	        return loginRepository.findById(id).orElseThrow(RuntimeException::new);
	    }
	  
	  @PostMapping
	    public ResponseEntity createUserLogin(@RequestBody User user) throws URISyntaxException {
		  User savedUserLogin = loginRepository.save(user);
	        return ResponseEntity.created(new URI("/login/" + savedUserLogin.getId())).body(savedUserLogin);
	    }
	  @PutMapping("/{id}")
	    public ResponseEntity updateUserLogin(@PathVariable Long id, @RequestBody User userLogin) {
	    	User currentUserLogin = loginRepository.findById(id).orElseThrow(RuntimeException::new);
	    	currentUserLogin.setUsername(currentUserLogin.getUsername());
	    	currentUserLogin.setUserMailid(currentUserLogin.getUserMailid());
	    	currentUserLogin.setPassword(currentUserLogin.getPassword());
	    	return ResponseEntity.ok(currentUserLogin);
	  }
	  @DeleteMapping("/{id}")
	    public ResponseEntity deleteUserLogin(@PathVariable Long id) {
		  loginRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
}