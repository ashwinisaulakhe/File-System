package com.filesystem.springapp.services;

import java.util.Optional;

import com.filesystem.springapp.dao.UserRegModel;
import com.filesystem.springapp.entities.UserEntity;
import com.filesystem.springapp.entities.VerificationToken;

public interface UserEntityService {

	UserEntity registerUser(UserRegModel userRegModel);

	UserRegModel saveVerificationTokenForUser(String token, UserEntity userEntity);

	String validateVerificationToken(String token);

	VerificationToken generateNewVerificationToken(String oldToken);

	UserEntity findUserByEmail(String email);

	void createPasswordResetTokenForUser(UserEntity userEntity, String token);

	String validatePasswordResetToken(String token);

	Optional<UserEntity> getUserByPasswordResetToken(String token);

	void changePassword(UserEntity userEntity, String newPassword);

	boolean checkIfValidOldPassword(UserEntity userEntity, String oldPassword);

}


