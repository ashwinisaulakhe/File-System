package com.filesystem.springapp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.filesystem.springapp.entities.UserRegistration;
import com.filesystem.springapp.repositories.UserRegRepository;
import com.filesystem.springapp.serviceImpl.UserRegServiceImpl;


@Service("userService")
public class UserRegService implements UserRegServiceImpl{

	
	    @Autowired
	    private UserRegRepository userRegRepository;

	    @Autowired
	    PasswordEncoder passwordEncoder;

	     @Override
	    public void register(UserRegistration user) throws UserAlreadyExistAuthenticationException {

	        //Let's check if user already registered with us
	        if(checkIfUserExist(user.getUser_mailid())){
	            throw new UserAlreadyExistAuthenticationException("User already exists for this email");
	        }
	        UserRegistration userRegistration = new UserRegistration();
	        BeanUtils.copyProperties(user, userRegistration);
	        encodePassword(userRegistration, user);
	        userRegRepository.save(userRegistration);
	    }

		@Override
	    public boolean checkIfUserExist(String userMailid) {
	        return (userRegRepository).findByEmail(userMailid) !=null ? true : false;
	    }
		
	    private void encodePassword(UserRegistration userRegistration, UserRegistration user){
	    	userRegistration.setUser_passwd(passwordEncoder.encode(userRegistration.getUser_passwd()));
	    }
}

