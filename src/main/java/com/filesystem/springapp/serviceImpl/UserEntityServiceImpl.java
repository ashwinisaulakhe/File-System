package com.filesystem.springapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.filesystem.springapp.dao.UserRegModel;
import com.filesystem.springapp.entities.UserEntity;
import com.filesystem.springapp.entities.VerificationToken;
import com.filesystem.springapp.repositories.UserEntityRepository;
import com.filesystem.springapp.repositories.VerificationTokenRepository;
import com.filesystem.springapp.services.UserEntityService;


@Service
@Component
public class UserEntityServiceImpl implements UserEntityService {

	
	@Autowired(required=false)
	private UserEntityRepository userEntityRepository;
	
	@Autowired(required=false)
	private PasswordEncoder passwordEncoder;
	
	@Autowired(required=false)
	private VerificationTokenRepository verificationTokenRepository;
	
	@Override
	public UserEntity registerUser(UserRegModel userRegModel) {
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail(userRegModel.getEmail());
		userEntity.setFirstName(userRegModel.getFirstName());
		userEntity.setLastName(userRegModel.getLastName());
		userEntity.setRoles("USER ROLE");
		userEntity.setPassword(passwordEncoder.encode(userRegModel.getPassword()));
		
		userEntityRepository.save(userEntity);
		return userEntity;
	}

	@Override
	public UserRegModel saveVerificationTokenForUser(String token, UserEntity userEntity) {
		VerificationToken verificationToken=
				new VerificationToken(userEntity,token);
		
		verificationTokenRepository.save(verificationToken);
		return null;
		
	}

	

	
}
