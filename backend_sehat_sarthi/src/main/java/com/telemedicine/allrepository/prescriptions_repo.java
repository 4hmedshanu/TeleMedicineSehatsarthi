package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.prescriptions;

@Repository
public interface prescriptions_repo extends JpaRepository<prescriptions, Long> {

}
