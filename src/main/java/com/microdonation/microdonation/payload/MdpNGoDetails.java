package com.microdonation.microdonation.payload;

import com.microdonation.microdonation.model.User;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MdpNGoDetails {

	private User user;

   	private long userId;

    private long id;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 40)
    private String ngoName;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String registrationId;

    private String redistrationDate;

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

    public String veriifiedBy;
    
    private String contactPerson;  //added by yogesh
    
	private String userIdType; //added by yogesh
	
	private String emailOtp; //added by yogesh
	
	private String phoneOtp; //added by yogesh
	
	private boolean agreeToTerms; //added by yogesh

    public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRedistrationDate() {
        return redistrationDate;
    }

    public void setRedistrationDate(String redistrationDate) {
        this.redistrationDate = redistrationDate;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNgoDesc() {
        return ngoDesc;
    }

    public void setNgoDesc(String ngoDesc) {
        this.ngoDesc = ngoDesc;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public String getSecondaryCategory() {
        return secondaryCategory;
    }

    public void setSecondaryCategory(String secondaryCategory) {
        this.secondaryCategory = secondaryCategory;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getFundTransferRef() {
        return fundTransferRef;
    }

    public void setFundTransferRef(String fundTransferRef) {
        this.fundTransferRef = fundTransferRef;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVeriifiedBy() {
        return veriifiedBy;
    }

    public void setVeriifiedBy(String veriifiedBy) {
        this.veriifiedBy = veriifiedBy;
    }

	public String getUserIdType() {
		return userIdType;
	}

	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}

	public String getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}

	public String getPhoneOtp() {
		return phoneOtp;
	}

	public void setPhoneOtp(String phoneOtp) {
		this.phoneOtp = phoneOtp;
	}

	public boolean isAgreeToTerms() {
		return agreeToTerms;
	}

	public void setAgreeToTerms(boolean agreeToTerms) {
		this.agreeToTerms = agreeToTerms;
	}
    
    
}
