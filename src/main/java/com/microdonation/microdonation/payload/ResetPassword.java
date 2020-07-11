package com.microdonation.microdonation.payload;

import javax.validation.constraints.NotBlank;

public class ResetPassword {
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@NotBlank
	private String username;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ResetPassword{" +
				"password='" + password + '\'' +
				", confirmPassword='" + confirmPassword + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
