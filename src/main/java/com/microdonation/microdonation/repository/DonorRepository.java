package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.MdpDonor;
import com.microdonation.microdonation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<MdpDonor, Long> {

    public MdpDonor findByUser(User user);
}
