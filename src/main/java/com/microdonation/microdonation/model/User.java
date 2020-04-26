package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "M_MDP_USERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "szUsername"
        }),
        @UniqueConstraint(columnNames = {
            "szEmail"
        })
})
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String szName;

    @NotBlank
    @Size(max = 15)
    private String szUsername;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String szEmail;

    @NotBlank
    @Size(max = 100)
    private String szPassword;

    @Size(max = 10)
    @NotNull
    private String szRole;

    private long szMobile;

    private long iOtp;

    private boolean cUserStatus;

    private boolean cUserLocked;

    @Temporal(TemporalType.DATE)
    private Calendar dtCreated;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSzName() {
        return szName;
    }

    public void setSzName(String szName) {
        this.szName = szName;
    }

    public String getSzUsername() {
        return szUsername;
    }

    public void setSzUsername(String szUsername) {
        this.szUsername = szUsername;
    }

    public String getSzEmail() {
        return szEmail;
    }

    public void setSzEmail(String szEmail) {
        this.szEmail = szEmail;
    }

    public String getSzPassword() {
        return szPassword;
    }

    public void setSzPassword(String szPassword) {
        this.szPassword = szPassword;
    }

    public String getSzRole() {
        return szRole;
    }

    public void setSzRole(String szRole) {
        this.szRole = szRole;
    }

    public long getSzMobile() {
        return szMobile;
    }

    public void setSzMobile(long szMobile) {
        this.szMobile = szMobile;
    }

    public long getiOtp() {
        return iOtp;
    }

    public void setiOtp(long iOtp) {
        this.iOtp = iOtp;
    }

    public boolean iscUserStatus() {
        return cUserStatus;
    }

    public void setcUserStatus(boolean cUserStatus) {
        this.cUserStatus = cUserStatus;
    }

    public boolean iscUserLocked() {
        return cUserLocked;
    }

    public void setcUserLocked(boolean cUserLocked) {
        this.cUserLocked = cUserLocked;
    }

    public Calendar getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Calendar dtCreated) {
        this.dtCreated = dtCreated;
    }
}