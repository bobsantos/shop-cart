package com.devworkz.shopcart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import com.devworkz.shopcart.domain.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByEmail(String email);
}