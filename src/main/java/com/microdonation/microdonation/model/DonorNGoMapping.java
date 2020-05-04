package com.microdonation.microdonation.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class DonorNGoMapping implements Serializable {

    @NotNull
    private Long iDonorId;

    @NotNull
    private Long iNgoId;

    public DonorNGoMapping() {

    }

    public DonorNGoMapping(Long iDonorId, Long iNgoId) {
        this.iDonorId = iDonorId;
        this.iNgoId = iNgoId;
    }

    public Long getiDonorId() {
        return iDonorId;
    }

    public void setiDonorId(Long iDonorId) {
        this.iDonorId = iDonorId;
    }

    public Long getiNgoId() {
        return iNgoId;
    }

    public void setiNgoId(Long iNgoId) {
        this.iNgoId = iNgoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DonorNGoMapping that = (DonorNGoMapping) o;

        if (!iDonorId.equals(that.iDonorId)) return false;
        return iNgoId.equals(that.iNgoId);
    }

    @Override
    public int hashCode() {
        int result = iDonorId.hashCode();
        result = 31 * result + iNgoId.hashCode();
        return result;
    }
}
