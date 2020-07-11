package com.microdonation.microdonation.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ForgotPassword {

	@NotBlank
	private String emailIdOrMobileNo;
	
	@NotBlank	
	private String sendOTP;
	

	public String getEmailIdOrMobileNo() {
		return emailIdOrMobileNo;
	}
	public void setEmailIdOrMobileNo(String emailIdOrMobileNo) {
		this.emailIdOrMobileNo = emailIdOrMobileNo;
	}
	public String getSendOTP() {
		return sendOTP;
	}
	public void setSendOTP(String sendOTP) {
		this.sendOTP = sendOTP;
	}	


}
