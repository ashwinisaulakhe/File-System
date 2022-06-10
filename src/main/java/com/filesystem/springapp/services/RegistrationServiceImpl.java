package com.filesystem.springapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.filesystem.springapp.entities.Registration;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	List<Registration> list;
	
	public RegistrationServiceImpl()
	{
		list=new ArrayList<>();
		list.add(new Registration("Jhon",123456789,"jhon@yahoo.com","@$6484!0","@$6484!0"));
		list.add(new Registration("rabika",344648989,"rabika@gmail.com","abc@123","abc@123"));
	}

	@Override
	public List<Registration> getRegistration() {
		// TODO Auto-generated method stub
		return null;
	}

}
	
	



