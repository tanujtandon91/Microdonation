package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.TmdpDonorRef;
import com.microdonation.microdonation.model.TmdpNgoRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NgoReferenceRepository extends JpaRepository<TmdpNgoRef,Long> {

    @Query(value = "Select * from t_mdp_ngo_ref where i_ngo_id=:id",nativeQuery = true)
    public List<TmdpNgoRef> findByNgoId(@Param("id") Long id);

    Boolean existsBySzMobile(String mobile);

    Boolean existsBySzEmail(String email);

    public Optional<TmdpNgoRef> findBySzEmailAndSzMobile(String email, String mobile);

}
