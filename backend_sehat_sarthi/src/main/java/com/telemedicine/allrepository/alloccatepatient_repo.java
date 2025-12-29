package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.Doctor;
import com.telemedicine.allentity.allocatepatient;
import com.telemedicine.allentity.patient;

import java.util.List;
import java.util.Optional;


@Repository
public interface alloccatepatient_repo extends JpaRepository<allocatepatient, Long> {
	List<allocatepatient> findByDoctor(Doctor doctor);
	Optional<allocatepatient> findByPatient(patient patient);

}
