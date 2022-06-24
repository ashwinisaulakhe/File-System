package com.filesystem.springapp.serviceImpl;

import javax.validation.Valid;

import com.filesystem.springapp.controller.UserAlreadyExistException;
import com.filesystem.springapp.dao.UserData;

public interface UserEntityService {

	void register(@Valid UserData userData);
	public boolean checkIfUserExist(String email);
}
