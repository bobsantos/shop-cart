package com.devworkz.shopcart.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name="app_user_role")
public class UserRole {
	public enum UserRoleType { ROLE_USER, ROLE_ADMIN };
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@JsonProperty
	private UserRoleType role;
	
	@ManyToOne
	@JsonProperty
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserRoleType getRole() {
		return role;
	}

	public void setRole(UserRoleType role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
