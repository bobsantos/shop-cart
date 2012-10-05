package com.devworkz.shopcart.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devworkz.shopcart.domain.User;
import com.devworkz.shopcart.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/auth/*")
public class SecurityController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="user", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Object getAuthenticatedUser(HttpServletResponse res) throws Exception{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByEmail(username);
		
		return user;
	}
	
}
