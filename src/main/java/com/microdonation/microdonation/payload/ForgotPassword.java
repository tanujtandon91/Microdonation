package com.microdonation.microdonation.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ForgotPassword {

	@NotBlank
	private String username;
	
	@NotBlank	
	private String sendOTP;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSendOTP() {
		return sendOTP;
	}

	public void setSendOTP(String sendOTP) {
		this.sendOTP = sendOTP;
	}

	@Override
	public String toString() {
		return "ForgotPassword{" +
				"username='" + username + '\'' +
				", sendOTP='" + sendOTP + '\'' +
				'}';
	}
}
