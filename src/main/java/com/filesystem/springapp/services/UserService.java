package com.filesystem.springapp.services;

import com.filesystem.springapp.entities.Registration;
import com.filesystem.springapp.web.dto.UserRegistrationDto;

public interface UserService {

	Registration save(UserRegistrationDto registrationDto);
}
