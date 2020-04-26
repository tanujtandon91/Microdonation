package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.User;
import com.microdonation.microdonation.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository
        extends JpaRepository<VerificationToken, Long> {

    VerificationToken findBySzToken(String token);

    VerificationToken findByUser(User user);
}
