package com.microdonation.microdonation.payload;

import java.util.List;

public class MyNgoRequest {

    private Long userId;

    private List<NgoDetails> ngoDetails;

    public static class NgoDetails
    {
        private Long ngoId;

        private int pymtAllocPercentage;

        public Long getNgoId() {
            return ngoId;
        }

        public void setNgoId(Long ngoId) {
            this.ngoId = ngoId;
        }

        public int getPymtAllocPercentage() {
            return pymtAllocPercentage;
        }

        public void setPymtAllocPercentage(int pymtAllocPercentage) {
            this.pymtAllocPercentage = pymtAllocPercentage;
        }
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<NgoDetails> getNgoDetails() {
        return ngoDetails;
    }

    public void setNgoDetails(List<NgoDetails> ngoDetails) {
        this.ngoDetails = ngoDetails;
    }
}
