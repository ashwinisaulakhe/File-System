package com.filesystem.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.filesystem.springapp.dao.AuthenticationRequest;
import com.filesystem.springapp.dao.AuthenticationResponse;
import com.filesystem.springapp.services.MyUserDetailsService;
import com.filesystem.springapp.util.JWTUtil;

@Controller
public class HelloResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtil jwtTokenUtil;
	
	@RequestMapping({"/hello"})
	public String hello()
	{
		return "Hello World";
	}
	
	@RequestMapping(value ="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken (@RequestBody AuthenticationRequest authenticationRequest)throws Exception{
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
				(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect username and password",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt =jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse (jwt));
		
	}
}
