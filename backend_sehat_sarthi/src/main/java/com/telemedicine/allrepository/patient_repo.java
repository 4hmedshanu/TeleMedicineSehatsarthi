package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.patient;
import com.telemedicine.allentity.user;

import java.util.Optional;
import java.util.List;



@Repository
public interface patient_repo extends JpaRepository<patient, Long> {
	
	Optional<patient> findByPatientId(Long patientId);
	 Optional<patient> findByUser(user user);
	
}
