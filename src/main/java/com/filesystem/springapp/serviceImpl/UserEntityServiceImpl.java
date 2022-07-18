package com.filesystem.springapp.serviceImpl;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.filesystem.springapp.dao.UserRegModel;
import com.filesystem.springapp.entities.PasswordResetToken;
import com.filesystem.springapp.entities.UserEntity;
import com.filesystem.springapp.entities.VerificationToken;
import com.filesystem.springapp.repositories.PasswordResetTokenRepository;
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
	
	@Autowired(required =false)
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	@Autowired(required=false)
	private VerificationTokenRepository verificationTokenRepository;
	
	@Override
	public UserEntity registerUser(UserRegModel userRegModel) {
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail(userRegModel.getEmail());
		userEntity.setFirstName(userRegModel.getFirstName());
		userEntity.setLastName(userRegModel.getLastName());
		userEntity.setPhoneNumber(userRegModel.getPhoneNumber());
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

	@Override
	public String validateVerificationToken(String token) {
		// TODO Auto-generated method stub
		VerificationToken verificationToken= verificationTokenRepository.findByToken(token);
		
		if(verificationToken == null)
		{
			return "invalid token";
		}
		
		UserEntity userEntity= verificationToken.getUserEntity();
		Calendar cal =Calendar.getInstance();
		
		if((verificationToken.getExpirationTime1().getTime()-cal.getTime().getTime())<=0) {
			verificationTokenRepository.delete(verificationToken);
			return "expired";
		}
		
		userEntity.setEnabled(true);
		userEntityRepository.save(userEntity);
		return "valid";
	}

	@Override
	public VerificationToken generateNewVerificationToken(String oldToken) {
		// TODO Auto-generated method stub
		
		VerificationToken verificationToken= verificationTokenRepository.findByToken(oldToken);
		verificationToken.setToken(UUID.randomUUID().toString());
		verificationTokenRepository.save(verificationToken);
		
		return verificationToken;
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userEntityRepository.findByEmail(email);
	}

	@Override
	public void createPasswordResetTokenForUser(UserEntity userEntity, String token) {
		// TODO Auto-generated method stub
		PasswordResetToken passwordResetToken = new PasswordResetToken(userEntity,token);
		passwordResetTokenRepository.save(passwordResetToken);
		
	}

	@Override
	public String validatePasswordResetToken(String token) {
		// TODO Auto-generated method stub
		PasswordResetToken passwordResetToken= passwordResetTokenRepository.findByToken(token);
		
		if(passwordResetToken == null)
		{
			return "invalid";
		}
		
		UserEntity userEntity= passwordResetToken.getUserEntity();
		Calendar cal =Calendar.getInstance();
		
		if((passwordResetToken.getExpirationTime1().getTime()-cal.getTime().getTime())<=0) {
			passwordResetTokenRepository.delete(passwordResetToken);
			return "expired";
		}
		
		return "valid";
		
	}

	@Override
	public Optional<UserEntity> getUserByPasswordResetToken(String token) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUserEntity());
	}

	@Override
	public void changePassword(UserEntity userEntity, String newPassword) {
		// TODO Auto-generated method stub
		userEntity.setPassword(passwordEncoder.encode(newPassword));
		userEntityRepository.save(userEntity);
		
		
	}

	@Override
	public boolean checkIfValidOldPassword(UserEntity userEntity, String oldPassword) {
		// TODO Auto-generated method stub
		return passwordEncoder.matches(oldPassword, userEntity.getPassword());
	}

}