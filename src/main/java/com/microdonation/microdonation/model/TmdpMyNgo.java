package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "T_MDP_MY_NGO")
public class TmdpMyNgo implements Serializable {

    // I_DONOR_ID	INTEGER	10
    @Id
    private Long iDonorId;

    @Id
    private Long iNgoId;

    //F_RECUR_PMT_ALLOC_1	STRING	1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iRecurPayAllocSeq;

    //F_RECUR_PMT_ALLOC_1	FLOAT	3
    @Column(precision=3, scale=2)
    private float fRecurPmtAllocPer;

    //  DT_CREATED	DATE
    @Temporal(TemporalType.DATE)
    //@Column(columnDefinition="COMMENT 'Date of creation'")
    private Calendar dtCreated;

    public Long getiDonorId() {
        return iDonorId;
    }

    public void setiDonorId(Long iDonorId) {
        this.iDonorId = iDonorId;
    }

    public Long getiNgoId() {
        return iNgoId;
    }

    public void setiNgoId(Long iNgoId) {
        this.iNgoId = iNgoId;
    }

    public int getiRecurPayAllocSeq() {
        return iRecurPayAllocSeq;
    }

    public void setiRecurPayAllocSeq(int iRecurPayAllocSeq) {
        this.iRecurPayAllocSeq = iRecurPayAllocSeq;
    }

    public float getfRecurPmtAllocPer() {
        return fRecurPmtAllocPer;
    }

    public void setfRecurPmtAllocPer(float fRecurPmtAllocPer) {
        this.fRecurPmtAllocPer = fRecurPmtAllocPer;
    }

    public Calendar getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Calendar dtCreated) {
        this.dtCreated = dtCreated;
    }
}
