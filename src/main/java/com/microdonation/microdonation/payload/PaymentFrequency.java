package com.microdonation.microdonation.payload;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

public class PaymentFrequency {
    @NotNull
    private Long ngoId;

    @NotNull
    private String paymentFrequency;

    @NotNull
    private float amount;

    @NotNull
        private int paymentDay;

    private Calendar nextReminderDate;

    private String paymentGatewayCode;

    public Long getNgoId() {
        return ngoId;
    }

    public void setNgoId(Long ngoId) {
        this.ngoId = ngoId;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(int paymentDay) {
        this.paymentDay = paymentDay;
    }

    public Calendar getNextReminderDate() {
        return nextReminderDate;
    }

    public void setNextReminderDate(Calendar nextReminderDate) {
        this.nextReminderDate = nextReminderDate;
    }

    public String getPaymentGatewayCode() {
        return paymentGatewayCode;
    }

    public void setPaymentGatewayCode(String paymentGatewayCode) {
        this.paymentGatewayCode = paymentGatewayCode;
    }
}
