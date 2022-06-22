package com.filesystem.springapp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.filesystem.springapp.dto.UserData;
import com.filesystem.springapp.entities.UserRegistration;
import com.filesystem.springapp.repositories.UserRegRepository;
import com.filesystem.springapp.serviceImpl.UserAlreadyExistsException;
import com.filesystem.springapp.serviceImpl.UserRegService;


@Service("userService")
public class DefaultUserRegService implements UserRegService{

	@Autowired
	private UserRegRepository userRegRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void register(UserData userData) throws UserAlreadyExistsException {
		if (CheckIfUserExist(userData.getUserMailid())) {
			throw new UserAlreadyExistsException("user already exist for this email");
		}
		UserRegistration userRegistration =new UserRegistration();
		BeanUtils.copyProperties(userData, userRegistration);
		encodePassword(userData,userRegistration);
		userRegRepository.save(userRegistration);
		
	}

	@Override
	public boolean CheckIfUserExist(String userMailid) {
		return userRegRepository.findByEmail(userMailid)!=null ? true : false;
	}
	
	private void encodePassword(UserData source,UserRegistration target)
	{
		target.setUser_passwd(passwordEncoder.encode(source.getUserPasswd()));
	}

	
	
}
