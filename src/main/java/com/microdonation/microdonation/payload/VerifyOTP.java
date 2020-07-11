package com.microdonation.microdonation.payload;

import javax.validation.constraints.NotBlank;

public class VerifyOTP {
    @NotBlank
    private String username;

    @NotBlank
    private String otp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
