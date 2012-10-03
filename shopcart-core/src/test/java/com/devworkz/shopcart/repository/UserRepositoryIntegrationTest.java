package com.devworkz.shopcart.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.devworkz.shopcart.domain.User;

@ContextConfiguration(locations="classpath:spring/app-config.xml")
public class UserRepositoryIntegrationTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private UserRepository repository;
	
	@Test
	public void shouldFindExistingUserByEmail(){
		// given
		String email = "admin@test.com";
		
		// when
		User user = repository.findByEmail(email);
		
		// then
		assertNotNull(user);
		assertEquals(email, user.getEmail());
	}
}
