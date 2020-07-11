package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "M_MDP_DONOR")
public class MdpDonor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iDonorId;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "szUserId")
    private User user;

    @NotBlank
    @Size(max = 40)
    private String szDonorName;

    private String szAddressLine1;

    private String szAddressLine2;

    private String szCity;

    private String szState;

    private String szCountry;

    private String szPostalCode;

    private String szPhone;

    private String szMobile;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String szEmail;

    private boolean cDonorStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreatedDate;

    private float fTotalDonation;

    private float fTotalDonationCy;

    private float fTotalDonationCm;

    @Temporal(TemporalType.DATE)
    private Calendar dtLastPaymentDate;

    private float fLastDonationAmount;

    private String szPaymentGatewayCode;
    
   private int iAge; //added by yogesh
   
   private String szOccupation;  //added by yogesh
  
   private String szUserIdType; //added by yogesh
   
   private String szEmailOtp;  //added by yogesh
   
   private String szPhoneOtp;  //added by yogesh
   
   private boolean cAgreeToTerms;  //added by yogesh

    public Long getiDonorId() {
        return iDonorId;
    }

    public void setiDonorId(Long iDonorId) {
        this.iDonorId = iDonorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSzDonorName() {
        return szDonorName;
    }

    public void setSzDonorName(String szDonorName) {
        this.szDonorName = szDonorName;
    }

    public String getSzAddressLine1() {
        return szAddressLine1;
    }

    public void setSzAddressLine1(String szAddressLine1) {
        this.szAddressLine1 = szAddressLine1;
    }

    public String getSzAddressLine2() {
        return szAddressLine2;
    }

    public void setSzAddressLine2(String szAddressLine2) {
        this.szAddressLine2 = szAddressLine2;
    }

    public String getSzCity() {
        return szCity;
    }

    public void setSzCity(String szCity) {
        this.szCity = szCity;
    }

    public String getSzState() {
        return szState;
    }

    public void setSzState(String szState) {
        this.szState = szState;
    }

    public String getSzCountry() {
        return szCountry;
    }

    public void setSzCountry(String szCountry) {
        this.szCountry = szCountry;
    }

    public String getSzPostalCode() {
        return szPostalCode;
    }

    public void setSzPostalCode(String szPostalCode) {
        this.szPostalCode = szPostalCode;
    }

    public String getSzPhone() {
        return szPhone;
    }

    public void setSzPhone(String szPhone) {
        this.szPhone = szPhone;
    }

    public String getSzMobile() {
        return szMobile;
    }

    public void setSzMobile(String szMobile) {
        this.szMobile = szMobile;
    }

    public String getSzEmail() {
        return szEmail;
    }

    public void setSzEmail(String szEmail) {
        this.szEmail = szEmail;
    }

    public boolean iscDonorStatus() {
        return cDonorStatus;
    }

    public void setcDonorStatus(boolean cDonorStatus) {
        this.cDonorStatus = cDonorStatus;
    }

    public Date getDtCreatedDate() {
        return dtCreatedDate;
    }

    public void setDtCreatedDate(Date dtCreatedDate) {
        this.dtCreatedDate = dtCreatedDate;
    }

    public float getfTotalDonation() {
        return fTotalDonation;
    }

    public void setfTotalDonation(float fTotalDonation) {
        this.fTotalDonation = fTotalDonation;
    }

    public float getfTotalDonationCy() {
        return fTotalDonationCy;
    }

    public void setfTotalDonationCy(float fTotalDonationCy) {
        this.fTotalDonationCy = fTotalDonationCy;
    }

    public float getfTotalDonationCm() {
        return fTotalDonationCm;
    }

    public void setfTotalDonationCm(float fTotalDonationCm) {
        this.fTotalDonationCm = fTotalDonationCm;
    }

    public Calendar getDtLastPaymentDate() {
        return dtLastPaymentDate;
    }

    public void setDtLastPaymentDate(Calendar dtLastPaymentDate) {
        this.dtLastPaymentDate = dtLastPaymentDate;
    }

    public float getfLastDonationAmount() {
        return fLastDonationAmount;
    }

    public void setfLastDonationAmount(float fLastDonationAmount) {
        this.fLastDonationAmount = fLastDonationAmount;
    }

    public String getSzPaymentGatewayCode() {
        return szPaymentGatewayCode;
    }

    public void setSzPaymentGatewayCode(String szPaymentGatewayCode) {
        this.szPaymentGatewayCode = szPaymentGatewayCode;
    }

	public int getiAge() {
		return iAge;
	}

	public void setiAge(int iAge) {
		this.iAge = iAge;
	}

	public String getSzOccupation() {
		return szOccupation;
	}

	public void setSzOccupation(String szOccupation) {
		this.szOccupation = szOccupation;
	}

	public String getSzUserIdType() {
		return szUserIdType;
	}

	public void setSzUserIdType(String szUserIdType) {
		this.szUserIdType = szUserIdType;
	}

	public String getSzEmailOtp() {
		return szEmailOtp;
	}

	public void setSzEmailOtp(String szEmailOtp) {
		this.szEmailOtp = szEmailOtp;
	}

	public String getSzPhoneOtp() {
		return szPhoneOtp;
	}

	public void setSzPhoneOtp(String szPhoneOtp) {
		this.szPhoneOtp = szPhoneOtp;
	}

	public boolean iscAgreeToTerms() {
		return cAgreeToTerms;
	}

	public void setcAgreeToTerms(boolean cAgreeToTerms) {
		this.cAgreeToTerms = cAgreeToTerms;
	}


    
    
}
