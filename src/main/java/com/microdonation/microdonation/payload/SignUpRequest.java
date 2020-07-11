package com.microdonation.microdonation.payload;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

@ApiModel(description = "Contains details For User Registration")
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

   
    @Size(max = 40)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    private String role;

    private long contactNo;

    private String registrationId;
    
    private String address; //added by yogesh
    
    private String ngoCategory; //added by yogesh
    
    private String ngoContPerson; //added by yogesh
    
    private int age;             //added by yogesh
    
    private String occupation; //added by yogesh
    
    private String city; //added by yogesh
    
    @ApiModelProperty(notes = "User Id type (Email or Phone No)", required = true)
    private String userIdType; //added by yogesh
    
    private String emailOtp; //added by yogesh
    
    private String phoneOtp; //added by yogesh
    
    private boolean agreeToTerms; //added by yogesh
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNgoCategory() {
		return ngoCategory;
	}

	public void setNgoCategory(String ngoCategory) {
		this.ngoCategory = ngoCategory;
	}

	public String getNgoContPerson() {
		return ngoContPerson;
	}

	public void setNgoContPerson(String ngoContPerson) {
		this.ngoContPerson = ngoContPerson;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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