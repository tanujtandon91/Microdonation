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
public class TmdpMyNgo {

    @EmbeddedId
    DonorNGoMapping donorNGoMapping;

    //F_RECUR_PMT_ALLOC_1	FLOAT	3
    @Column(precision=3, scale=2)
    private float fRecurPmtAllocPer;

    //  DT_CREATED	DATE
    @Temporal(TemporalType.DATE)
    //@Column(columnDefinition="COMMENT 'Date of creation'")
    private Calendar dtCreated;

    public DonorNGoMapping getDonorNGoMapping() {
        return donorNGoMapping;
    }

    public void setDonorNGoMapping(DonorNGoMapping donorNGoMapping) {
        this.donorNGoMapping = donorNGoMapping;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
