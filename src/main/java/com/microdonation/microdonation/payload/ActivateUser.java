package com.microdonation.microdonation.payload;

import lombok.Data;

@Data
public class ActivateUser {
    private String userName;
    private String otp;
}
