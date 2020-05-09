package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.DonorNGoMapping;
import com.microdonation.microdonation.model.TmdpDonorRecurPmtSetup;
import com.microdonation.microdonation.model.TmdpMyNgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonorPymtFreqRepository extends JpaRepository<TmdpDonorRecurPmtSetup, DonorNGoMapping> {

    @Query(value = "Select * from t_mdp_donor_recur_pmt_setup where i_donor_id=:id",nativeQuery = true)
    public List<TmdpDonorRecurPmtSetup> findByDonorId(@Param("id") Long id);

}
