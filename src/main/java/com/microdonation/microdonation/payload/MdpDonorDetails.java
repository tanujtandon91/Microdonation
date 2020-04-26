package com.microdonation.microdonation.payload;

import com.microdonation.microdonation.model.User;
import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MdpDonorDetails {

    private User user;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 40)
    private String donorName;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    private String registrationId;

    private Calendar redistrationDate;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String pincode;

    private String contactNo1;

    private String contactNo2;

    private String mobile;

    private String ngoDesc;

    private String primaryCategory;

    private String secondaryCategory;

    private String website;

    private String ifsc;

    private String bankAccountNo;

    private String fundTransferRef;

    private boolean locked;

    private boolean status;
}
