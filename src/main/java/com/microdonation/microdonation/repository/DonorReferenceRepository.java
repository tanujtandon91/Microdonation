package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.TmdpDonorRecurPmtSetup;
import com.microdonation.microdonation.model.TmdpDonorRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DonorReferenceRepository extends JpaRepository<TmdpDonorRef, Long> {

    @Query(value = "Select * from t_mdp_donor_ref where i_donor_id=:id",nativeQuery = true)
    public List<TmdpDonorRef> findByDonorId(@Param("id") Long id);

    public Optional<TmdpDonorRef> findBySzEmailAndSzMobile(String email, String mobile);

    Boolean existsBySzMobile(String mobile);

    Boolean existsBySzEmail(String email);



}
