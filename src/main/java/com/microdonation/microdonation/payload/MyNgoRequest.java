package com.microdonation.microdonation.payload;

public class MyNgoRequest {

    private Long userId;
    private Long ngoId;
    private int pymtAllocPercentage;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
