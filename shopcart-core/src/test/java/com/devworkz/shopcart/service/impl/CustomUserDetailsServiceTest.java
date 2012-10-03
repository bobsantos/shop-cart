package com.devworkz.shopcart.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.devworkz.shopcart.domain.User;
import com.devworkz.shopcart.domain.UserRole;
import com.devworkz.shopcart.domain.UserRole.UserRoleType;
import com.devworkz.shopcart.repository.UserRepository;


public class CustomUserDetailsServiceTest {
	private static final String TEST_PASSWORD = "test";
	private static final Long TEST_ID = 1L;
	private static final String TEST_EMAIL = "test";
	
	private CustomUserDetailsService service;
	@Mock
	private UserRepository userRepository;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		
		service = new CustomUserDetailsService();
		service.setUserRepository(userRepository);
	}
	
	@Test
	public void shouldReturnUserDetailsOfExistingUser(){
		// given
		User user= createUser();
		when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(user);
		
		// when
		UserDetails actual = service.loadUserByUsername(TEST_EMAIL); 
		
		
		// then
		assertNotNull(actual);
		assertEquals(user.getEmail(), actual.getUsername());
		assertEquals(user.getPassword(), actual.getPassword());
		assertNotNull(actual.getAuthorities());
		assertEquals(user.getRoles().size(), actual.getAuthorities().size());
	}
	
	@Test(expected=UsernameNotFoundException.class)
	public void shouldNotReturnUserDetailsForNonExistingUser(){
		// given
		when(userRepository.findByEmail(TEST_EMAIL)).thenReturn(null);
		
		// when
		service.loadUserByUsername(TEST_EMAIL);
	}

	private User createUser() {
		User user = new User();
		user.setEmail(TEST_EMAIL);
		user.setId(TEST_ID);
		user.setPassword(TEST_PASSWORD);
		
		Set<UserRole> roles = new HashSet<UserRole>();
		UserRole role = createRole(user);
		role.setRole(UserRoleType.ROLE_ADMIN);
		roles.add(role);
		
		user.setRoles(roles);
		
		return user;
	}


	private UserRole createRole(User user) {
		UserRole role = new UserRole();
		role.setId(TEST_ID);
		role.setUser(user);
		return role;
	}
}
