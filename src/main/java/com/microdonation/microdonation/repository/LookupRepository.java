package com.microdonation.microdonation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.microdonation.microdonation.model.tLookup;

public interface LookupRepository extends JpaRepository<tLookup, Long> {

	@Query(value = "Select * from t_lookup where sz_lookup_type=:type",nativeQuery = true)
    public List<tLookup> fetchLookup(@Param("type") String type);

}
