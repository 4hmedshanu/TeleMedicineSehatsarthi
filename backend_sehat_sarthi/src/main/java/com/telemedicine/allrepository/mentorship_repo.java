package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.mentorship;

@Repository
public interface mentorship_repo extends JpaRepository<mentorship, Long> {
	

}
