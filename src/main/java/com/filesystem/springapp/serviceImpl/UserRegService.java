package com.filesystem.springapp.serviceImpl;

import com.filesystem.springapp.dto.UserData;

public interface UserRegService {

	void register(final UserData userData)throws UserAlreadyExistsException;
	boolean CheckIfUserExist(final String UserMailId);
}
