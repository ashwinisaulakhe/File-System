package com.filesystem.springapp.event;

import org.springframework.context.ApplicationEvent;

import com.filesystem.springapp.entities.UserEntity;

public class RegistrationCompleteEvent extends ApplicationEvent{

	private UserEntity userEntity;
	private String applicationUrl;
	public RegistrationCompleteEvent(UserEntity userEntity, String applicationUrl) {
		
		super(userEntity);
		this.userEntity=userEntity;
		this.applicationUrl=applicationUrl;
		// TODO Auto-generated constructor stub
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public String getApplicationUrl() {
		return applicationUrl;
	}
	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}
	

}
