package com.wf.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.wf.Encryptor;
import com.wf.UserDao;
import com.wf.Validator;

import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

	private AuthenticationService authService;
	private UserDao userDao;
	private Validator validator;
	private Encryptor encryptor;
	
	@Test
	public void testEncryptorsCalledWhenCreateUser(){
		String userName = "sam";
		String password = "23213213";
		when(encryptor.encrypt(password)).thenReturn("@#$%@%!#45fdf");
		when(validator.validateLength(userName)).thenReturn(true);
		when(validator.validateBlank(userName)).thenReturn(true);
		when(validator.validateLength(password)).thenReturn(true);
		when(validator.validateBlank(password)).thenReturn(true);
		authService.createUser(userName,password);
		verify(encryptor,times(1)).encrypt(password);
	}
	
	
	@Test(expected=AuthenticationServiceException.class)
	public void testValidationFail(){
		String userName = "sam";
		String password = "23213213";
		when(validator.validateLength(userName)).thenReturn(false);
		authService.createUser(userName,password);
	}
	
	@Test
	public void testValidatorsCalledWhenCreateUser(){
		String userName = "sam";
		String password = "23213213";
		when(validator.validateLength(userName)).thenReturn(true);
		when(validator.validateBlank(userName)).thenReturn(true);
		
		when(validator.validateLength(password)).thenReturn(true);
		when(validator.validateBlank(password)).thenReturn(true);
		
		authService.createUser(userName,password);
		verify(validator,times(1)).validateLength(userName);
		verify(validator,times(1)).validateLength(password);
		verify(validator,times(1)).validateBlank(userName);
		verify(validator,times(1)).validateBlank(password);
	}
	
	@Test
	public void testUserDaoCalledWhenCreateUser(){
		String userName = "sam";
		String password = "23213213";
		when(encryptor.encrypt(password)).thenReturn(password);
		when(validator.validateLength(userName)).thenReturn(true);
		when(validator.validateBlank(userName)).thenReturn(true);
		
		when(validator.validateLength(password)).thenReturn(true);
		when(validator.validateBlank(password)).thenReturn(true);
		
		when(userDao.insert(userName, password)).thenReturn(true);
		authService.createUser(userName,password);
		verify(userDao,times(1)).insert(userName,password);
	}
	
	
	@Before
	public void setUp() throws Exception {
		authService = new AuthenticationService();
		userDao = mock(UserDao.class);
		authService.setUserDao(userDao);
		
		validator = mock(Validator.class);
		authService.setValidator(validator);

		encryptor = mock(Encryptor.class);
		authService.setEncryptor(encryptor);
	}

	@After
	public void tearDown() throws Exception {
		authService = null;
	}

	@Test
	public void testSetup() {
		assertNotNull(authService);
	}

}
