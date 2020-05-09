package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.MdpNgo;
import com.microdonation.microdonation.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NgoRepository extends JpaRepository<MdpNgo, Long> {
	
    public MdpNgo findByUser(User user);

}
