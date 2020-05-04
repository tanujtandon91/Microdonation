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
@Table(name = "T_MDP_NGO_REF")
public class TmdpNgoRef implements Serializable {

    @OneToOne(targetEntity = MdpNgo.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iNgoId" )
    private MdpNgo iNgoId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iNgoReferanceId;  // I_REFERENCE_ID

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

    public MdpNgo getiNgoId() {
        return iNgoId;
    }

    public void setiNgoId(MdpNgo iNgoId) {
        this.iNgoId = iNgoId;
    }

    public Long getiNgoReferanceId() {
        return iNgoReferanceId;
    }

    public Long iNgoReferanceId() {
        return iNgoReferanceId;
    }

    public void setiNgoReferanceId(Long iNgoReferanceId) {
        this.iNgoReferanceId = iNgoReferanceId;
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
