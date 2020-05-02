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
@Table(name = "T_MDP_DONOR_REF")
public class TmdpDonorRef implements Serializable{


   // I_DONOR_ID	INTEGER	10
    @Id
    @OneToOne(targetEntity = MdpDonor.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iDonorId" )
    private Long iDonorId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iReferanceId;  // I_REFERENCE_ID

    @NotBlank
    @Size(max = 60)
    private String szRefName; //SZ_REF_NAME	STRING	60

    @Size(max = 12)
    private String szMobile;

    @NaturalId
    @NotBlank
    @Size(max = 60)
    @Email
    private String szEmail;//SZ_EMAIL	STRING	60

    private boolean cConversionStatus; //C_CONVERSION_STATUS

    @Temporal(TemporalType.DATE)
    private Calendar dtLastReminder; //DT_last_reminder

    private int iReminderNo; //I_Reminder_No INTEGER	3

    public Long getiDonorId() {
        return iDonorId;
    }

    public void setiDonorId(Long iDonorId) {
        this.iDonorId = iDonorId;
    }

    public Long getiReferanceId() {
        return iReferanceId;
    }

    public void setiReferanceId(Long iReferanceId) {
        this.iReferanceId = iReferanceId;
    }

    public String getSzRefName() {
        return szRefName;
    }

    public void setSzRefName(String szRefName) {
        this.szRefName = szRefName;
    }

    public String getSzMobile() {
        return szMobile;
    }

    public void setSzMobile(String szMobile) {
        this.szMobile = szMobile;
    }

    public String getSzEmail() {
        return szEmail;
    }

    public void setSzEmail(String szEmail) {
        this.szEmail = szEmail;
    }

    public boolean iscConversionStatus() {
        return cConversionStatus;
    }

    public void setcConversionStatus(boolean cConversionStatus) {
        this.cConversionStatus = cConversionStatus;
    }

    public Calendar getDtLastReminder() {
        return dtLastReminder;
    }

    public void setDtLastReminder(Calendar dtLastReminder) {
        this.dtLastReminder = dtLastReminder;
    }

    public int getiReminderNo() {
        return iReminderNo;
    }

    public void setiReminderNo(int iReminderNo) {
        this.iReminderNo = iReminderNo;
    }
}
