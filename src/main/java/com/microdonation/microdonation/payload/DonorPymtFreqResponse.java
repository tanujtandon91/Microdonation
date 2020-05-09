package com.microdonation.microdonation.payload;

import java.util.List;

public class DonorPymtFreqResponse {

    private Long userId;

    private List<PaymentFrequency> donorFrequency;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PaymentFrequency> getDonorFrequency() {
        return donorFrequency;
    }

    public void setDonorFrequency(List<PaymentFrequency> donorFrequency) {
        this.donorFrequency = donorFrequency;
    }
}
