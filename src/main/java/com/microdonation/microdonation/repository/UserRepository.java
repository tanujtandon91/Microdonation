package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBySzEmail(String email);

    Optional<User> findBySzUsernameOrSzEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findBySzUsername(String username);

    Boolean existsBySzUsername(String username);

    Boolean existsBySzEmail(String email);
}