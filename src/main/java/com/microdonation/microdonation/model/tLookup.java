package com.microdonation.microdonation.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_LOOKUP")
@IdClass(tLookup.class)
public class tLookup implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 375024524593040916L;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;

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

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }
}
