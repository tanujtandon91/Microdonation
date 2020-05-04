package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "T_MDP_DONOR_PAYMENT")
public class TmdpDonorPayment implements Serializable {

    //I_DONOR_ID	INTEGER	10
    @OneToOne(targetEntity = MdpDonor.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iDonorId" )
    private MdpDonor iDonorId;

    //I_PAYMENT_ID	INTEGER	10
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iPaymnetId;

    //DT_PAYMENT	DATE
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPayment;

    @Column(precision=20, scale=3)
    private float fAmount;

    //SZ_PAYMENT_MODE	STRING	20 Mode of payment - NEFT, RTGS, IMPS, ….


    public MdpDonor getiDonorId() {
        return iDonorId;
    }

    public void setiDonorId(MdpDonor iDonorId) {
        this.iDonorId = iDonorId;
    }

    public Long getiPaymnetId() {
        return iPaymnetId;
    }

    public void setiPaymnetId(Long iPaymnetId) {
        this.iPaymnetId = iPaymnetId;
    }

    public Date getDtPayment() {
        return dtPayment;
    }

    public void setDtPayment(Date dtPayment) {
        this.dtPayment = dtPayment;
    }

    public float getfAmount() {
        return fAmount;
    }

    public void setfAmount(float fAmount) {
        this.fAmount = fAmount;
    }
}
