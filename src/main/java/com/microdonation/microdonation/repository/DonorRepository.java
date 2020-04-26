package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.MdpDonor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<MdpDonor, Long> {

}
