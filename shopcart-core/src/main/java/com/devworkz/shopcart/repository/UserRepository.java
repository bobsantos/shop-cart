package com.devworkz.shopcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devworkz.shopcart.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}