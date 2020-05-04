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
@Table(name = "T_MDP_NGO_DOCS")
public class TmdpNgoDocs implements Serializable{

    @OneToOne(targetEntity = MdpNgo.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "iNgoId" )
    private MdpNgo iNgoId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iDocumentId;  // I_DOCUMENT_ID

    @NotBlank
    @Size(max = 60)
    private String szDocumentType; //SZ_DOCUMENT_TYPE	STRING	60

    @Lob
    private byte[] objDocument;

    @Temporal(TemporalType.DATE)
    private Calendar dtUpload; //DT_UPLOAD

    public MdpNgo getiNgoId() {
        return iNgoId;
    }

    public void setiNgoId(MdpNgo iNgoId) {
        this.iNgoId = iNgoId;
    }

    public Long getiDocumentId() {
        return iDocumentId;
    }

    public void setiDocumentId(Long iDocumentId) {
        this.iDocumentId = iDocumentId;
    }

    public String getSzDocumentType() {
        return szDocumentType;
    }

    public void setSzDocumentType(String szDocumentType) {
        this.szDocumentType = szDocumentType;
    }

    public byte[] getObjDocument() {
        return objDocument;
    }

    public void setObjDocument(byte[] objDocument) {
        this.objDocument = objDocument;
    }

    public Calendar getDtUpload() {
        return dtUpload;
    }

    public void setDtUpload(Calendar dtUpload) {
        this.dtUpload = dtUpload;
    }
}
