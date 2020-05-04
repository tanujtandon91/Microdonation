package com.microdonation.microdonation.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.microdonation.microdonation.model.MdpDonor;
import com.microdonation.microdonation.model.MdpNgo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DonorNGoPymtFreqRequest {

    @NotNull
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
