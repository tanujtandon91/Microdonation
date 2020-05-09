package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.DonorNGoMapping;
import com.microdonation.microdonation.model.MdpDonor;
import com.microdonation.microdonation.model.TmdpMyNgo;
import com.microdonation.microdonation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MyNgoRepository extends JpaRepository<TmdpMyNgo, DonorNGoMapping> {

    @Query(value = "Select * from t_mdp_my_ngo where i_donor_id=:id",nativeQuery = true)
    public List<TmdpMyNgo> findByDonorId(@Param("id") Long id);


}
