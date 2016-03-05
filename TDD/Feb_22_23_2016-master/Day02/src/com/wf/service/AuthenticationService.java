package com.wf.service;

import com.wf.Encryptor;
import com.wf.UserDao;
import com.wf.Validator;

public class AuthenticationService {

	private UserDao userDao;
	private Validator validator;
	private Encryptor encryptor;
	
	public boolean createUser(String userName, String password) {
		boolean created = false;
		if(validator.validateBlank(userName) &&
				validator.validateLength(userName) &&
				validator.validateBlank(password) &&
				validator.validateLength(password)){
			String encryptedPassword = encryptor.encrypt(password);
			created = userDao.insert(userName, encryptedPassword);	
		}
		else
			throw new AuthenticationServiceException("Validation failed");
		return created;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public void setEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

}
