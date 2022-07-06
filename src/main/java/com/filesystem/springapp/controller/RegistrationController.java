package com.filesystem.springapp.controller;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filesystem.springapp.dao.PasswordModel;
import com.filesystem.springapp.dao.UserRegModel;
import com.filesystem.springapp.entities.UserEntity;
import com.filesystem.springapp.entities.VerificationToken;
import com.filesystem.springapp.event.RegistrationCompleteEvent;
import com.filesystem.springapp.event.log;
import com.filesystem.springapp.services.UserEntityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/register")
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
	
	@GetMapping("/verifyRegistration")
	public String verifyRegistration(@RequestParam("token") String token) {
		String result = userEntityService.validateVerificationToken(token);
		if(result.equalsIgnoreCase("valid")) {
			return "User verified Successfully";
		}
		return "Bad User";
	}
	
	@GetMapping("/resendVerifyToken")
	public String resendVerificationtoken(@RequestParam("token") String oldToken, HttpServletRequest request)
	{
		VerificationToken verificationToken= userEntityService.generateNewVerificationToken(oldToken);
		UserEntity userEntity= verificationToken.getUserEntity();
		resendVerificationTokenMail(userEntity, applicationUrl(request), verificationToken);
		return "verification Link Sent";
		
	}
	
	@PostMapping("/resetPassword")
	public String resetPassword(@RequestBody PasswordModel passwordModel, HttpServletRequest request) {
		UserEntity userEntity= userEntityService.findUserByEmail(passwordModel.getEmail());
		String url="";
		if(userEntity!= null) {
			String token= UUID.randomUUID().toString();
			userEntityService.createPasswordResetTokenForUser(userEntity,token);
			url = passwordResetTokenMail(userEntity,applicationUrl(request),token);
		}
		return url;
		
	}
	
	@PostMapping("/savePassword")
	public String savePassword(@RequestParam("token") String token, @RequestBody PasswordModel passwordModel) {
		
		String result= userEntityService.validatePasswordResetToken(token);
		if(!result.equalsIgnoreCase("valid")) {
			return "invalid token";
		}
		Optional<UserEntity>userEntity=userEntityService.getUserByPasswordResetToken(token);
		if(userEntity.isPresent()) {
			userEntityService.changePassword(userEntity.get(), passwordModel.getNewPassword());
			return "Password Reset Successfully";
		}
		else
		{
			return "invalid token";
		}
	
		
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody PasswordModel passwordModel)
	{
		UserEntity userEntity=userEntityService.findUserByEmail(passwordModel.getEmail());
		if(!userEntityService.checkIfValidOldPassword(userEntity,passwordModel.getOldPassword())) {
			return "invalid Old Password";
		}
		//save new password functionality
		userEntityService.changePassword(userEntity, passwordModel.getNewPassword());
		return "Password changed Successfully";
		
	}
	
	private String passwordResetTokenMail(UserEntity userEntity, String applicationUrl, String token) {
		// TODO Auto-generated method stub
		String url = applicationUrl +"/savePassword?token=" + token;
		

		//send verificationEmail
		log.info("Click the link to Reset your Password: {}",url);
		return url;
	}

	private void resendVerificationTokenMail(UserEntity userEntity, String applicationUrl, VerificationToken verificationToken) {
		// TODO Auto-generated method stub
		String url = applicationUrl +"/verifyRegistration?token=" + verificationToken.getToken();
		

		//send verificationEmail
		log.info("Click the link to verify your account: {}",url);
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
