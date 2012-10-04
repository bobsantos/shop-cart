package com.devworkz.shopcart.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@Table(name="app_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty
	private Long id;
	
	@Column
	@JsonProperty
	private String email;
	
	@Column
	@JsonIgnore
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="app_user_user_role", 
		joinColumns={@JoinColumn(name="app_user_id")},
		inverseJoinColumns={@JoinColumn(name="app_user_role_id")})
	@JsonProperty
	private Set<UserRole> roles;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
}
