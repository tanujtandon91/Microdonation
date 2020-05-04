package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "T_MDP_DONOR_RECUR_PMT_SETUP")

public class TmdpDonorRecurPmtSetup {

    // I_DONOR_ID	INTEGER	10

    @EmbeddedId
    private DonorNGoMapping donorNGoMapping;

    //SZ_PMT_FREQ	STRING	1
    @NotBlank
    @Size(max = 1)
  //  @Column(columnDefinition="COMMENT 'Recurring Payment Frequency W,M'")
    private String szPmtFreq;

    //F_AMOUNT	FLOAT	20,3
    @Column(precision=20, scale=3)// ,columnDefinition="COMMENT 'Recurring Payment Amount'")
    private float fAmount;

    //I_CYCLE_DAY	INTEGER	2
    //@Size (max=2)
    @Column( length = 2)
    private int iCycleDay;

    //  DT_NEXT_REMINDER	DATE
    @Temporal(TemporalType.DATE)
    //@Column(columnDefinition="COMMENT 'Next Reminder Date for Payment'")
    private Calendar dtNextReminder;

    //  DT_CREATED	DATE
    @Temporal(TemporalType.TIMESTAMP)
    //@Column(columnDefinition="COMMENT 'Date of creation'")
    private Date dtCreated;

    //SZ_Payment_gateway_code	STRING	20
    @Size(max = 20)
   // @Column(columnDefinition="COMMENT 'Payment gateway code'")
    private String szPaymentGetwayCode;

    public DonorNGoMapping getDonorNGoMapping() {
        return donorNGoMapping;
    }

    public void setDonorNGoMapping(DonorNGoMapping donorNGoMapping) {
        this.donorNGoMapping = donorNGoMapping;
    }

    public String getSzPmtFreq() {
        return szPmtFreq;
    }

    public void setSzPmtFreq(String szPmtFreq) {
        this.szPmtFreq = szPmtFreq;
    }

    public float getfAmount() {
        return fAmount;
    }

    public void setfAmount(float fAmount) {
        this.fAmount = fAmount;
    }

    public int getiCycleDay() {
        return iCycleDay;
    }

    public void setiCycleDay(int iCycleDay) {
        this.iCycleDay = iCycleDay;
    }

    public Calendar getDtNextReminder() {
        return dtNextReminder;
    }

    public void setDtNextReminder(Calendar dtNextReminder) {
        this.dtNextReminder = dtNextReminder;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getSzPaymentGetwayCode() {
        return szPaymentGetwayCode;
    }

    public void setSzPaymentGetwayCode(String szPaymentGetwayCode) {
        this.szPaymentGetwayCode = szPaymentGetwayCode;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
