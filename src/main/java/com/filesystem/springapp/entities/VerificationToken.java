package com.filesystem.springapp.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ForeignKey;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

	//Expiration time 10 minute
	private static final int EXPIRATION_TIME=10;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String token;
	
	private Date expirationTime;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name ="user_id",
	nullable = false,
	foreignKey = @ForeignKey(name ="FK_USER_VERIFY_TOKEN"))
	private UserEntity userEntity;

	public VerificationToken(UserEntity userEntity, String token) {
		super();
		
		this.token = token;
		this.userEntity = userEntity;
		this.expirationTime= calculateExpirationDate(EXPIRATION_TIME);
	}
	

	public VerificationToken(String token) {
		super();
		this.token = token;
		this.expirationTime =calculateExpirationDate(EXPIRATION_TIME);
	}


	private Date calculateExpirationDate(int expirationTime) {

		Calendar calendar= Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, expirationTime);
		return new Date(calendar.getTime().getTime());
	}
	
	
}
