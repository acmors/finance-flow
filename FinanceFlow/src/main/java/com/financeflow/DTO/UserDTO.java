package com.financeflow.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.financeflow.model.UserAccount;

public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	
	@JsonIgnore
	private String password;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public UserDTO(UserAccount user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		password = user.getPassword();
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
