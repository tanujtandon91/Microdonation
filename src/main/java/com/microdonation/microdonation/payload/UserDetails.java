package com.microdonation.microdonation.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDetails {
    @NotBlank
    @NotNull
    private String address;

    @NotBlank
    @NotNull
    private String city;

    @NotBlank
    @NotNull
    private String pincode;

    private String yearOfBirth;

    private String educationLevel;

    private String occupation;

    private String privacyFlag;

    @NotBlank
    private String dateOfIncorporaion;

    @NotBlank
    @NotNull
    private String registrationNo;

    private String website;

    @NotBlank
    @NotNull
    private String contactName;

    private String notes;

    private long userId;
}
