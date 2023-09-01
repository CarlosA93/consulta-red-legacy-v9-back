package com.claro.co.consultaredlegacyv9.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {

	@NotNull
	@NotEmpty(message = "please provide any value")
	private String userName;

	@NotNull
	@NotEmpty(message = "please provide any value")
	private String password;

	private String rol;
    
	private boolean isValidate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isValidate() {
		return isValidate;
	}

	public void setValidate(boolean isValidate) {
		this.isValidate = isValidate;
	}
}