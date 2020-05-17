package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.TmdpDonorNgoPymtRef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorNgoPaymentRefRepository  extends JpaRepository<TmdpDonorNgoPymtRef,Long> {

}
