package com.filesystem.springapp.services;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filesystem.springapp.entities.Registration;
import com.filesystem.springapp.entities.Role;
import com.filesystem.springapp.repositories.UserRepository;
import com.filesystem.springapp.web.dto.UserRegistrationDto;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Registration save(UserRegistrationDto registrationDto) {
		Registration registration=new Registration(registrationDto.getUserName(),
				registrationDto.getUser_phno(), registrationDto.getUser_mailid(),
				registrationDto.getUser_passwd(),Arrays.asList(new Role("UserRole")));
		
		return userRepository.save(registration);
	}

	

	

	
}