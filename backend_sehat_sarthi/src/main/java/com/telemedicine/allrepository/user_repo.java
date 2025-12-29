package com.telemedicine.allrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.user;
import java.util.List;
import java.util.Optional;


@Repository
public interface user_repo extends JpaRepository<user, Long> {
	Optional<user> findByEmail(String email);
	
}
