package com.filesystem.springapp.serviceImpl;

import com.filesystem.springapp.entities.UserRegistration;
import com.filesystem.springapp.services.UserAlreadyExistAuthenticationException;

public interface UserRegServiceImpl  {

	public void register(UserRegistration user) throws UserAlreadyExistAuthenticationException;
	boolean checkIfUserExist(String userMailid);
}
