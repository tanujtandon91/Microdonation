package com.microdonation.microdonation.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.microdonation.microdonation.model.MdpDonor;
import com.microdonation.microdonation.model.MdpNgo;
import com.microdonation.microdonation.model.TmdpDonorPayment;

import java.util.Date;
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonorNgoPaymentDetails {

    private Date paymentDate;

    private String paymentMode;

    private String PaymentType;

    private String trandactionId;

    private String paymentStatus;

    private String failureReason;

    private String failureNotification;

    private float fees;

    private float netAmount;

    private Long ngoId;

    private float totalAmount;

    private Long paymentrRefNo;

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public String getTrandactionId() {
        return trandactionId;
    }

    public void setTrandactionId(String trandactionId) {
        this.trandactionId = trandactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getFailureNotification() {
        return failureNotification;
    }

    public void setFailureNotification(String failureNotification) {
        this.failureNotification = failureNotification;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }

    public float getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(float netAmount) {
        this.netAmount = netAmount;
    }

    public Long getNgoId() {
        return ngoId;
    }

    public void setNgoId(Long ngoId) {
        this.ngoId = ngoId;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getPaymentrRefNo() {
        return paymentrRefNo;
    }

    public void setPaymentrRefNo(Long paymentrRefNo) {
        this.paymentrRefNo = paymentrRefNo;
    }
}
