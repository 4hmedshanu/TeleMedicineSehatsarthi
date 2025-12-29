package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.insurance;

@Repository
public interface insurance_repo extends JpaRepository<insurance, Long> {
	

}
