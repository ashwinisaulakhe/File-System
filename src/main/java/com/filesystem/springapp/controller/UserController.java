package com.filesystem.springapp.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.filesystem.springapp.entities.User;
import com.filesystem.springapp.repositories.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@ApiOperation(value="/login", tags ="user Controller")
@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping(path="/login")
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
	return "Login Successful";
    }
	
	@GetMapping("/logout")
	public String logout() { 
	return "/logout";
    }
	 
	@ApiOperation(value="Fetch all users", response=Iterable.class)
	@GetMapping
	public List<User> getUserLogin() {
        return loginRepository.findAll();
    }
	
	  @GetMapping("/{id}")
	  public User getUserLogin(@ApiParam(value="Id value for the login retrive",required =true)@PathVariable Long id) {
	        return loginRepository.findById(id).orElseThrow(RuntimeException::new);
	    }
	  
	  @ApiOperation(value="create User Login", response=User.class)
	  @PostMapping
	    public ResponseEntity createUserLogin(@RequestBody User user) throws URISyntaxException {
		  User savedUserLogin = loginRepository.save(user);
	        return ResponseEntity.created(new URI("/login/" + savedUserLogin.getId())).body(savedUserLogin);
	    }
	  
	  @ApiOperation(value="Update User Login", response=User.class)
	  @PutMapping("/{id}")
	    public ResponseEntity updateUserLogin(@PathVariable Long id, @RequestBody User userLogin) {
	    	User currentUserLogin = loginRepository.findById(id).orElseThrow(RuntimeException::new);
	    	currentUserLogin.setUsername(currentUserLogin.getUsername());
	    	currentUserLogin.setUserMailid(currentUserLogin.getUserMailid());
	    	currentUserLogin.setPassword(currentUserLogin.getPassword());
	    	return ResponseEntity.ok(currentUserLogin);
	  }
	  @ApiOperation(value="Delete User Login", response=User.class)
	  @DeleteMapping("/{id}")
	    public ResponseEntity deleteUserLogin(@PathVariable Long id) {
		  loginRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
}