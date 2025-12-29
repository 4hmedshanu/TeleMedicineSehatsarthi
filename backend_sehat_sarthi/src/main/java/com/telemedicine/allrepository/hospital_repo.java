package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.hospital;

import java.util.Optional;


@Repository
public interface hospital_repo extends JpaRepository<hospital,Long> {
	
	Optional<hospital> findByName(String name);
	
}
