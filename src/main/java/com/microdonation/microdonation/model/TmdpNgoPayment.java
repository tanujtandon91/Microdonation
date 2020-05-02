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
@Table(name = "T_MDP_NGO_PAYMENT")
public class TmdpNgoPayment implements Serializable {

    //I_PAYMENT_ID	INTEGER	10	Y	Y			Increamental Sequential ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iPaymnetId;

    //I_NGO_ID	INTEGER	10			T_MDP_NGO	I_NGO_ID	NGO ID reference
    @Id
    @OneToOne(targetEntity = MdpNgo.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iNgoId" )
    private Long iNgoId;

    //DT_PAYMENT	DATE						Payment Date
    @Temporal(TemporalType.DATE)
    private Calendar dtPayment;

    //F_AMOUNT	FLOAT	20,3					Payment Amount
    @Column(precision=20, scale=3)
    private float fAmount;

    //SZ_PAYMENT_MODE	STRING	20					Mode of payment - NEFT, RTGS, IMPS, ….
    @Size(max = 20)
    private String szPaymentMode;

    //SZ_IFSC_CODE	STRING	60					Bank of IFSC Code
    @Size(max = 20)
    private String szIfscCode;

    //SZ_BANK_ACCOUNT_NO	STRING	20					Bank Account No
    @Size(max = 20)
    private String szBankAccountNo;

    //SZ_CHQ_UTR_NO	STRING	20					Cheque or UTR No.
    @Size(max = 20)
    private String szChqUtrNo;

    public Long getiPaymnetId() {
        return iPaymnetId;
    }

    public void setiPaymnetId(Long iPaymnetId) {
        this.iPaymnetId = iPaymnetId;
    }

    public Long getiNgoId() {
        return iNgoId;
    }

    public void setiNgoId(Long iNgoId) {
        this.iNgoId = iNgoId;
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

    public String getSzIfscCode() {
        return szIfscCode;
    }

    public void setSzIfscCode(String szIfscCode) {
        this.szIfscCode = szIfscCode;
    }

    public String getSzBankAccountNo() {
        return szBankAccountNo;
    }

    public void setSzBankAccountNo(String szBankAccountNo) {
        this.szBankAccountNo = szBankAccountNo;
    }

    public String getSzChqUtrNo() {
        return szChqUtrNo;
    }

    public void setSzChqUtrNo(String szChqUtrNo) {
        this.szChqUtrNo = szChqUtrNo;
    }
}
