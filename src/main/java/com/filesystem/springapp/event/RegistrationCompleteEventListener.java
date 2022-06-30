package com.filesystem.springapp.event;


import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.filesystem.springapp.entities.UserEntity;
import com.filesystem.springapp.services.UserEntityService;


import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements 
	ApplicationListener<RegistrationCompleteEvent> {
	
	@Autowired
	private UserEntityService userEntityService;

	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// create the verification token for the user with link
		
		UserEntity userEntity= event.getUserEntity();
		String token= UUID.randomUUID().toString();
		userEntityService.saveVerificationTokenForUser(token,userEntity);
		
		//send mail to user
		String url = event.getApplicationUrl() +"/VerifyRegistration?token=" +token;
		

		//send verificationEmail
		log.info("Click the link to verify your account: {}",url);
	}

}
