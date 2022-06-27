package com.filesystem.springapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filesystem.springapp.dao.UserRegModel;
import com.filesystem.springapp.entities.UserEntity;
import com.filesystem.springapp.event.RegistrationCompleteEvent;
import com.filesystem.springapp.services.UserEntityService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserEntityService userEntityService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserRegModel userRegModel,final HttpServletRequest request) {

		UserEntity userEntity=userEntityService.registerUser(userRegModel);
		String applicationUrl;
		publisher.publishEvent(new RegistrationCompleteEvent(userEntity,
				applicationUrl(request) ));
		return "Success";
		
	}

	private String applicationUrl(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "http://"
				+ request.getServerName()+
				":" +
				request.getServerPort()+
				request.getContextPath();
	}
}
