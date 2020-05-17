package com.microdonation.microdonation.payload;

import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NgoReferenceRequest {

    @NotNull
    private long userId;

    @NotBlank
    @Size(max = 60)
    private String referenceName; //SZ_REF_NAME	STRING	60

    @Size(max = 12)
    private String mobile;

    @NaturalId
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;//SZ_EMAIL	STRING	60

    private boolean conversationStatus; //C_CONVERSION_STATUS

    private int reminderNo; //I_Reminder_No INTEGER	3

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isConversationStatus() {
        return conversationStatus;
    }

    public void setConversationStatus(boolean conversationStatus) {
        this.conversationStatus = conversationStatus;
    }

    public int getReminderNo() {
        return reminderNo;
    }

    public void setReminderNo(int reminderNo) {
        this.reminderNo = reminderNo;
    }
}
