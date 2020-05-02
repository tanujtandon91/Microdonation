package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "T_MDP_DONOR_PAYMENT")
public class TmdpDonorPayment implements Serializable {

    //I_DONOR_ID	INTEGER	10
    @Id
    @OneToOne(targetEntity = MdpDonor.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iDonorId" )
    private Long iDonorId;

    //I_PAYMENT_ID	INTEGER	10
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iPaymnetId;

    //DT_PAYMENT	DATE
    @Temporal(TemporalType.DATE)
    private Calendar dtPayment;

    //F_AMOUNT	FLOAT	20,3
    @Column(precision=20, scale=3)
    private float fAmount;

    //SZ_PAYMENT_MODE	STRING	20 Mode of payment - NEFT, RTGS, IMPS, ….
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

    //I_NGO_ID_1	INTEGER	10
    private Long iNgoIdNo1;

    //F_AMOUNT_1	Amount	20.3
    @Column(precision=20, scale=3)
    private float fAmount1;

    //I_NGO_ID_2	INTEGER	10
    private Long iNgoIdNo2;

    //F_AMOUNT_2	Amount	20.3
    @Column(precision=20, scale=3)
    private float fAmount2;

    //I_NGO_ID_3	INTEGER	10
    private Long iNgoIdNo3;
    //F_AMOUNT_3	Amount	20.3
    @Column(precision=20, scale=3)
    private float fAmount3;

    //I_NGO_1_payment_ref	INTEGER	10
    private Long iNgoIdNo1PaymentRef;

    //I_NGO_2_payment_ref	INTEGER	10
    private Long iNgoIdNo2PaymentRef;

    //I_NGO_3_payment_ref	INTEGER	10
    private Long iNgoIdNo3PaymentRef;

    public Long getiDonorId() {
        return iDonorId;
    }

    public void setiDonorId(Long iDonorId) {
        this.iDonorId = iDonorId;
    }

    public Long getiPaymnetId() {
        return iPaymnetId;
    }

    public void setiPaymnetId(Long iPaymnetId) {
        this.iPaymnetId = iPaymnetId;
    }

    public Calendar getDtPayment() {
        return dtPayment;
    }

    public void setDtPayment(Calendar dtPayment) {
        this.dtPayment = dtPayment;
    }

    public float getfAmount() {
        return fAmount;
    }

    public void setfAmount(float fAmount) {
        this.fAmount = fAmount;
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

    public Long getiNgoIdNo1() {
        return iNgoIdNo1;
    }

    public void setiNgoIdNo1(Long iNgoIdNo1) {
        this.iNgoIdNo1 = iNgoIdNo1;
    }

    public float getfAmount1() {
        return fAmount1;
    }

    public void setfAmount1(float fAmount1) {
        this.fAmount1 = fAmount1;
    }

    public Long getiNgoIdNo2() {
        return iNgoIdNo2;
    }

    public void setiNgoIdNo2(Long iNgoIdNo2) {
        this.iNgoIdNo2 = iNgoIdNo2;
    }

    public float getfAmount2() {
        return fAmount2;
    }

    public void setfAmount2(float fAmount2) {
        this.fAmount2 = fAmount2;
    }

    public Long getiNgoIdNo3() {
        return iNgoIdNo3;
    }

    public void setiNgoIdNo3(Long iNgoIdNo3) {
        this.iNgoIdNo3 = iNgoIdNo3;
    }

    public float getfAmount3() {
        return fAmount3;
    }

    public void setfAmount3(float fAmount3) {
        this.fAmount3 = fAmount3;
    }

    public Long getiNgoIdNo1PaymentRef() {
        return iNgoIdNo1PaymentRef;
    }

    public void setiNgoIdNo1PaymentRef(Long iNgoIdNo1PaymentRef) {
        this.iNgoIdNo1PaymentRef = iNgoIdNo1PaymentRef;
    }

    public Long getiNgoIdNo2PaymentRef() {
        return iNgoIdNo2PaymentRef;
    }

    public void setiNgoIdNo2PaymentRef(Long iNgoIdNo2PaymentRef) {
        this.iNgoIdNo2PaymentRef = iNgoIdNo2PaymentRef;
    }

    public Long getiNgoIdNo3PaymentRef() {
        return iNgoIdNo3PaymentRef;
    }

    public void setiNgoIdNo3PaymentRef(Long iNgoIdNo3PaymentRef) {
        this.iNgoIdNo3PaymentRef = iNgoIdNo3PaymentRef;
    }
}
