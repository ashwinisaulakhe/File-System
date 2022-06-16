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

import com.filesystem.springapp.entities.Registration;
import com.filesystem.springapp.entities.UserLogin;
import com.filesystem.springapp.repositories.UserLoginRepository;


@Controller
@RequestMapping("/login")
public class UserLoginController {

	private UserLoginRepository loginRepository;

	public UserLoginController(UserLoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}
	
	@GetMapping
	public List<UserLogin> getUserLogin() {
        return loginRepository.findAll();
    }
	
	  @GetMapping("/{id}")
	    public UserLogin getUserLogin(@PathVariable Long id) {
	        return loginRepository.findById(id).orElseThrow(RuntimeException::new);
	    }
	  
	  @PostMapping
	    public ResponseEntity createUserLogin(@RequestBody UserLogin userlogin) throws URISyntaxException {
		  UserLogin savedUserLogin = loginRepository.save(userlogin);
	        return ResponseEntity.created(new URI("/login/" + savedUserLogin.getId())).body(savedUserLogin);
	    }
	  @PutMapping("/{id}")
	    public ResponseEntity updateUserLogin(@PathVariable Long id, @RequestBody UserLogin userLogin) {
	    	UserLogin currentUserLogin = loginRepository.findById(id).orElseThrow(RuntimeException::new);
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
