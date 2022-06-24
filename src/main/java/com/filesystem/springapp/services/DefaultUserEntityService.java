package com.filesystem.springapp.services;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.filesystem.springapp.controller.UserAlreadyExistException;
import com.filesystem.springapp.dao.UserData;
import com.filesystem.springapp.entities.UserEntity;
import com.filesystem.springapp.repositories.UserEntityRepository;

@Transactional
@Service("userService")
public class DefaultUserEntityService {

	@Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    
    @Override
    public void register(UserData userData) throws UserAlreadyExistException {

        //Let's check if user already registered with us
        if(checkIfUserExist(userData.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userData, userEntity);
        encodePassword(userEntity, userData);
        userEntityRepository.save(userEntity);
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userEntityRepository.findByEmail(email) !=null ? true : false;
    }

    private void encodePassword( UserEntity userEntity, UserData user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}

