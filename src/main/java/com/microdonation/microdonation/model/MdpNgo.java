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
@Table(name = "M_MDP_NGO")
public class MdpNgo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iNgoId;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "szUserId")
    private User user;

    @NotBlank
    @NotNull
    private String szRegistrationId;

    @NotBlank
    @Size(max = 40)
    private String szNgoName;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String szEmail;

    @Temporal(TemporalType.DATE)
    private Calendar dtRegistration;

    private String szAddressLine1;

    private String szAddressAine2;

    private String szCity;

    private String szState;

    private String szCountry;

    private String szPostalCode;

    private String szPhone1;

    private String szPhone2;

    private String szMobile;

    private String szNgoDesc;

    private String szCategoryPrimary;

    private String szCategorySecondary;

    private String szWebsite;

    private String szIfscCode;

    private String szBankAccountNo;

    private String szFundTransferPref;

    private boolean cNgoStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreatedDate;

    @Temporal(TemporalType.DATE)
    private Calendar dtVerifiedDate;

    private String szVerifiedBy;

    private float fTotalPayment;

    private float fTotalPaymentCy;

    private float fTotalPaymentCm;

    public Long getiNgoId() {
        return iNgoId;
    }

    public void setiNgoId(Long iNgoId) {
        this.iNgoId = iNgoId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSzRegistrationId() {
        return szRegistrationId;
    }

    public void setSzRegistrationId(String szRegistrationId) {
        this.szRegistrationId = szRegistrationId;
    }

    public String getSzNgoName() {
        return szNgoName;
    }

    public void setSzNgoName(String szNgoName) {
        this.szNgoName = szNgoName;
    }

    public String getSzEmail() {
        return szEmail;
    }

    public void setSzEmail(String szEmail) {
        this.szEmail = szEmail;
    }

    public Calendar getDtRegistration() {
        return dtRegistration;
    }

    public void setDtRegistration(Calendar dtRegistration) {
        this.dtRegistration = dtRegistration;
    }

    public String getSzAddressLine1() {
        return szAddressLine1;
    }

    public void setSzAddressLine1(String szAddressLine1) {
        this.szAddressLine1 = szAddressLine1;
    }

    public String getSzAddressAine2() {
        return szAddressAine2;
    }

    public void setSzAddressAine2(String szAddressAine2) {
        this.szAddressAine2 = szAddressAine2;
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

    public String getSzPhone1() {
        return szPhone1;
    }

    public void setSzPhone1(String szPhone1) {
        this.szPhone1 = szPhone1;
    }

    public String getSzPhone2() {
        return szPhone2;
    }

    public void setSzPhone2(String szPhone2) {
        this.szPhone2 = szPhone2;
    }

    public String getSzMobile() {
        return szMobile;
    }

    public void setSzMobile(String szMobile) {
        this.szMobile = szMobile;
    }

    public String getSzNgoDesc() {
        return szNgoDesc;
    }

    public void setSzNgoDesc(String szNgoDesc) {
        this.szNgoDesc = szNgoDesc;
    }

    public String getSzCategoryPrimary() {
        return szCategoryPrimary;
    }

    public void setSzCategoryPrimary(String szCategoryPrimary) {
        this.szCategoryPrimary = szCategoryPrimary;
    }

    public String getSzCategorySecondary() {
        return szCategorySecondary;
    }

    public void setSzCategorySecondary(String szCategorySecondary) {
        this.szCategorySecondary = szCategorySecondary;
    }

    public String getSzWebsite() {
        return szWebsite;
    }

    public void setSzWebsite(String szWebsite) {
        this.szWebsite = szWebsite;
    }

    public String getSzIfscCode() {
        return szIfscCode;
    }

    public void setSzIfscCode(String szIfscCode) {
        this.szIfscCode = szIfscCode;
    }

    public String getSzBankAccountNo() {
        return szBankAccountNo;
    }

    public void setSzBankAccountNo(String szBankAccountNo) {
        this.szBankAccountNo = szBankAccountNo;
    }

    public String getSzFundTransferPref() {
        return szFundTransferPref;
    }

    public void setSzFundTransferPref(String szFundTransferPref) {
        this.szFundTransferPref = szFundTransferPref;
    }

    public boolean iscNgoStatus() {
        return cNgoStatus;
    }

    public void setcNgoStatus(boolean cNgoStatus) {
        this.cNgoStatus = cNgoStatus;
    }

    public Date getDtCreatedDate() {
        return dtCreatedDate;
    }

    public void setDtCreatedDate(Date dtCreatedDate) {
        this.dtCreatedDate = dtCreatedDate;
    }

    public Calendar getDtVerifiedDate() {
        return dtVerifiedDate;
    }

    public void setDtVerifiedDate(Calendar dtVerifiedDate) {
        this.dtVerifiedDate = dtVerifiedDate;
    }

    public String getSzVerifiedBy() {
        return szVerifiedBy;
    }

    public void setSzVerifiedBy(String szVerifiedBy) {
        this.szVerifiedBy = szVerifiedBy;
    }

    public float getfTotalPayment() {
        return fTotalPayment;
    }

    public void setfTotalPayment(float fTotalPayment) {
        this.fTotalPayment = fTotalPayment;
    }

    public float getfTotalPaymentCy() {
        return fTotalPaymentCy;
    }

    public void setfTotalPaymentCy(float fTotalPaymentCy) {
        this.fTotalPaymentCy = fTotalPaymentCy;
    }

    public float getfTotalPaymentCm() {
        return fTotalPaymentCm;
    }

    public void setfTotalPaymentCm(float fTotalPaymentCm) {
        this.fTotalPaymentCm = fTotalPaymentCm;
    }
}
