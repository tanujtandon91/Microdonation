package com.microdonation.microdonation.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "T_LOOKUP")
public class tLookup implements Serializable {
    @Id
    @NotBlank
    @Size(max = 60)
    private String szLookupCode; //SZ_LOOKUP_CODE
    @Id
    @Size(max = 60)
    private String szLookupType; //SZ_LOOKUP_type

    @Size(max = 60)
    private String szLookupValue; //SZ_LOOKUP_VALUE

    //  DT_CREATED	DATE
    @Temporal(TemporalType.DATE)
    private Calendar dtCreated;

    public String getSzLookupType() {
        return szLookupType;
    }

    public void setSzLookupType(String szLookupType) {
        this.szLookupType = szLookupType;
    }

    public String getSzLookupCode() {
        return szLookupCode;
    }

    public void setSzLookupCode(String szLookupCode) {
        this.szLookupCode = szLookupCode;
    }

    public String getSzLookupValue() {
        return szLookupValue;
    }

    public void setSzLookupValue(String szLookupValue) {
        this.szLookupValue = szLookupValue;
    }

    public Calendar getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Calendar dtCreated) {
        this.dtCreated = dtCreated;
    }
}
