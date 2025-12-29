package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.appointments;
import com.telemedicine.allentity.patient;

import java.util.List;


@Repository
public interface appointment_repo extends JpaRepository<appointments, Long> {
	List<appointments> findByPatient(patient patient);
	
	
	
}
