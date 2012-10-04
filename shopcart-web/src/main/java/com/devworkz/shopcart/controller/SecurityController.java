package com.devworkz.shopcart.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

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
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userRepository.findByEmail(principal.getUsername());
		return user;
	}
	
}
