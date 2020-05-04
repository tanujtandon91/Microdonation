package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.TmdpDonorRecurPmtSetup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorPymtFreqRepository extends JpaRepository<TmdpDonorRecurPmtSetup, Long> {

}
