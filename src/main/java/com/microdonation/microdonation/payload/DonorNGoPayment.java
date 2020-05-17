package com.microdonation.microdonation.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.List;
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonorNGoPayment {
    @NotNull
    private Long userId;

    private String paymentDate;

    private float totalAmount;

    private List<DonorNgoPaymentDetails> paymentDetails;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        totalAmount = totalAmount;
    }

    public List<DonorNgoPaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<DonorNgoPaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
