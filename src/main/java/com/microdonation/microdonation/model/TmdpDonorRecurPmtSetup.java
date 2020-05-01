package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Entity
@Table(name = "T_MDP_DONOR_RECUR_PMT_SETUP")

public class TmdpDonorRecurPmtSetup {

    // this is temp field for testing
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iSeqID;

    // I_DONOR_ID	INTEGER	10
    @OneToOne(targetEntity = MdpDonor.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iDonorId" )
    private Long iDonorId;

    @OneToOne(targetEntity = MdpNgo.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iNgoId")
    private Long iNgoId;

    //SZ_PMT_FREQ	STRING	1
    @NotBlank
    @Size(max = 1)
  //  @Column(columnDefinition="COMMENT 'Recurring Payment Frequency W,M'")
    private String szPmtFreq;

    //F_AMOUNT	FLOAT	20,3
    @Column(precision=20, scale=3)// ,columnDefinition="COMMENT 'Recurring Payment Amount'")
    private float fAmount;

    //I_CYCLE_DAY	INTEGER	2
    @Size (max=2)
    //@Column(columnDefinition="COMMENT 'cycle Day'")
    private int iCycleDay;

    //  DT_NEXT_REMINDER	DATE
    @Temporal(TemporalType.DATE)
    //@Column(columnDefinition="COMMENT 'Next Reminder Date for Payment'")
    private Calendar dtNextReminder;

    //  DT_CREATED	DATE
    @Temporal(TemporalType.DATE)
    //@Column(columnDefinition="COMMENT 'Date of creation'")
    private Calendar dtCreated;

    //SZ_Payment_gateway_code	STRING	20
    @Size(max = 20)
   // @Column(columnDefinition="COMMENT 'Payment gateway code'")
    private String szPaymentGetwayCode;


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

    public Calendar getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Calendar dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getSzPaymentGetwayCode() {
        return szPaymentGetwayCode;
    }

    public void setSzPaymentGetwayCode(String szPaymentGetwayCode) {
        this.szPaymentGetwayCode = szPaymentGetwayCode;
    }
}
