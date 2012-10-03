package com.devworkz.shopcart.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.devworkz.shopcart.domain.User;
import com.devworkz.shopcart.domain.UserRole;
import com.devworkz.shopcart.repository.UserRepository;

@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		try {
			User user = userRepository.findByEmail(username);
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			UserDetails details = new org.springframework.security.core.userdetails.User(
					user.getEmail(), 
					user.getPassword(), 
					enabled , 
					accountNonExpired , 
					credentialsNonExpired , 
					accountNonLocked, 
					getAuthorities(user.getRoles()));
			
			return details;
		} catch (Exception e) {
			throw new UsernameNotFoundException("Username not found");
		}
	}

	private Collection<? extends GrantedAuthority> getAuthorities(
			Set<UserRole> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserRole userRole : roles) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole().name()));
		}
		return authorities;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
