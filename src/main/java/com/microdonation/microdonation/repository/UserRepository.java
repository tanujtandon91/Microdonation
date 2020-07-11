package com.microdonation.microdonation.repository;

import com.microdonation.microdonation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBySzEmail(String email);

    Optional<User> findBySzUsernameOrSzEmail(String username, String email);

    Optional<User> findBySzUsername(String username);

    Boolean existsBySzUsername(String username);

    Boolean existsBySzEmail(String email);
    
    Optional<User> findByszResetOtp(String resetOtp);

    Boolean existsBySzMobile(long mobileNo);

    @Query(value = "Select * from m_mdp_users where id=:id and c_user_status = 1",nativeQuery = true)
    User  findByIdAndCUserStatus(@Param("id") Long id);

    Optional<User> findBySzUsernameAndSzResetOtp(String username, String resetOtp);

}