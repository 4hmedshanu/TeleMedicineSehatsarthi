package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.Doctor;
import com.telemedicine.allentity.user;

import java.util.Optional;
import java.util.List;



@Repository
public interface doctor_repo extends JpaRepository<Doctor, Long> {
	
	Optional<Doctor> findByDoctorId(Long doctorId);
	Optional<Doctor> findByUser(user user);
	
	
	
}
