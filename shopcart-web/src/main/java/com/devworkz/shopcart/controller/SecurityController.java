package com.devworkz.shopcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devworkz.shopcart.domain.User;
import com.devworkz.shopcart.repository.UserRepository;

@Controller
@RequestMapping("/auth/*")
public class SecurityController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="user", method=RequestMethod.GET)
	public @ResponseBody User getAuthenticatedUser(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByEmail(username);
		return user;
	}
	
}
