package com.microdonation.microdonation.payload;

import javax.validation.constraints.NotBlank;

public class ResetPassword {
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@NotBlank
	private String resetOtp;
	
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

	public String getResetOtp() {
		return resetOtp;
	}

	public void setResetOtp(String resetOtp) {
		this.resetOtp = resetOtp;
	}


}
