package com.microdonation.microdonation.model;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

public class TmdpDonorNgoPymtRef {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iPaymnetId;

    @OneToMany(targetEntity = TmdpDonorPayment.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iPaymentId" )
    private TmdpDonorPayment iDonorPaymentId;


    private Long iDonorId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dtPayment;

    @Size(max = 20)
    private String szPaymentMode;

    //C_Payment_type	Character	1 Recurring/Regular
    @Size(max = 1)
    private String cPaymentType;

    //C_Payment_tran_ID	STRING	20 Payment gateway trxn id
    @Size(max = 20)
    private String cPaymentTranID;

    //C_Payment_status	Character	1 Payment success/failure
    @Size(max = 1)
    private String cPaymentStatus;

    //SZ_Failuree_Reason	STRING	20
    @Size(max = 80)
    private String szFailureReason;

    //C_failure_notification	Character	1
    @Size(max = 1)
    private String cFailureNotification;

    //F_fees	Amount	20.3 Processing fee
    @Column(precision=20, scale=3)
    private float fFees;

    //F_net_amount	Amount	20.3
    @Column(precision=20, scale=3)
    private float fNetAmount;

    @OneToOne(targetEntity = MdpNgo.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iNgoId" )
    private MdpNgo iNgoId;


    @Column(precision=20, scale=3)
    private float fAmount;

    //I_NGO_1_payment_ref	INTEGER	10
    private Long iNgoIdNoPaymentRef;

    public Long getiPaymnetId() {
        return iPaymnetId;
    }

    public void setiPaymnetId(Long iPaymnetId) {
        this.iPaymnetId = iPaymnetId;
    }

    public TmdpDonorPayment getiDonorPaymentId() {
        return iDonorPaymentId;
    }

    public void setiDonorPaymentId(TmdpDonorPayment iDonorPaymentId) {
        this.iDonorPaymentId = iDonorPaymentId;
    }

    public Long getiDonorId() {
        return iDonorId;
    }

    public void setiDonorId(Long iDonorId) {
        this.iDonorId = iDonorId;
    }

    public Date getDtPayment() {
        return dtPayment;
    }

    public void setDtPayment(Date dtPayment) {
        this.dtPayment = dtPayment;
    }

    public String getSzPaymentMode() {
        return szPaymentMode;
    }

    public void setSzPaymentMode(String szPaymentMode) {
        this.szPaymentMode = szPaymentMode;
    }

    public String getcPaymentType() {
        return cPaymentType;
    }

    public void setcPaymentType(String cPaymentType) {
        this.cPaymentType = cPaymentType;
    }

    public String getcPaymentTranID() {
        return cPaymentTranID;
    }

    public void setcPaymentTranID(String cPaymentTranID) {
        this.cPaymentTranID = cPaymentTranID;
    }

    public String getcPaymentStatus() {
        return cPaymentStatus;
    }

    public void setcPaymentStatus(String cPaymentStatus) {
        this.cPaymentStatus = cPaymentStatus;
    }

    public String getSzFailureReason() {
        return szFailureReason;
    }

    public void setSzFailureReason(String szFailureReason) {
        this.szFailureReason = szFailureReason;
    }

    public String getcFailureNotification() {
        return cFailureNotification;
    }

    public void setcFailureNotification(String cFailureNotification) {
        this.cFailureNotification = cFailureNotification;
    }

    public float getfFees() {
        return fFees;
    }

    public void setfFees(float fFees) {
        this.fFees = fFees;
    }

    public float getfNetAmount() {
        return fNetAmount;
    }

    public void setfNetAmount(float fNetAmount) {
        this.fNetAmount = fNetAmount;
    }

    public MdpNgo getiNgoId() {
        return iNgoId;
    }

    public void setiNgoId(MdpNgo iNgoId) {
        this.iNgoId = iNgoId;
    }

    public float getfAmount() {
        return fAmount;
    }

    public void setfAmount(float fAmount) {
        this.fAmount = fAmount;
    }

    public Long getiNgoIdNoPaymentRef() {
        return iNgoIdNoPaymentRef;
    }

    public void setiNgoIdNoPaymentRef(Long iNgoIdNoPaymentRef) {
        this.iNgoIdNoPaymentRef = iNgoIdNoPaymentRef;
    }
}
