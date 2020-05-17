package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.DonorNGoMapping;
import com.microdonation.microdonation.model.TmdpDonorPayment;
import com.microdonation.microdonation.model.TmdpDonorRecurPmtSetup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorNgoPaymentReposiory extends JpaRepository<TmdpDonorPayment, Long> {

}
