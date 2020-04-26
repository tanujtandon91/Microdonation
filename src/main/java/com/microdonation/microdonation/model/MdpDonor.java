package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Entity
@Table(name = "M_MDP_DONOR")
public class MdpDonor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iDonorId;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "szUserId")
    private User user;

    @NotBlank
    @Size(max = 40)
    private String szDonorName;

    private String szAddressLine1;

    private String szAddressLine2;

    private String szCity;

    private String szState;

    private String szCountry;

    private String szPostalCode;

    private String szPhone;

    private String szMobile;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String szEmail;

    private boolean cDonorStatus;

    @Temporal(TemporalType.DATE)
    private Calendar dtCreatedDate;

    private float fTotalDonation;

    private float fTotalDonationCy;

    private float fTotalDonationCm;

    @Temporal(TemporalType.DATE)
    private Calendar dtLastPaymentDate;

    private float fLastDonationAmount;

    private String szPaymentGatewayCode;

}
