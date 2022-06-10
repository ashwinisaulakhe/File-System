package com.filesystem.springapp.services;


import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.filesystem.springapp.entities.Registration;
import com.filesystem.springapp.entities.Role;
import com.filesystem.springapp.repositories.UserRepository;
import com.filesystem.springapp.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {


	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Registration save(UserRegistrationDto registrationDto) {
		Registration user=new Registration(registrationDto.getFirstName(),
				registrationDto.getLastName(),registrationDto.getEmailId(),
				registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
	
			return userRepository.save(user);
	}
}