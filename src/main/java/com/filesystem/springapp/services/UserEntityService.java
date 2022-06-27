package com.filesystem.springapp.services;

import com.filesystem.springapp.dao.UserRegModel;
import com.filesystem.springapp.entities.UserEntity;

public interface UserEntityService {

	UserEntity registerUser(UserRegModel userRegModel);

	UserRegModel saveVerificationTokenForUser(String token, UserEntity userEntity);

	

}
