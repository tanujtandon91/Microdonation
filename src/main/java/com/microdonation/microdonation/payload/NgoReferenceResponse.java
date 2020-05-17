package com.microdonation.microdonation.payload;

import java.util.List;

public class NgoReferenceResponse {
    private long userId;

    private List<NgoReferenceResponse.Reference> references;

    public static class Reference{
        private String referenceName; //SZ_REF_NAME	STRING	60

        private String mobile;

        private String email;//SZ_EMAIL	STRING	60

        private boolean conversationStatus; //C_CONVERSION_STATUS

        private int reminderNo; //I_Reminder_No INTEGER	3

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
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<NgoReferenceResponse.Reference> getReferences() {
        return references;
    }

    public void setReferences(List<NgoReferenceResponse.Reference> references) {
        this.references = references;
    }
}
