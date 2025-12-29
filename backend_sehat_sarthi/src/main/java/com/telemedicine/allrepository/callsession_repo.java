package com.telemedicine.allrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telemedicine.allentity.calsession;
import java.util.List;
import com.telemedicine.allentity.calsession.CallStatus;


@Repository
public interface callsession_repo extends JpaRepository<calsession, Long> {
	 // ✅ Only this method works without @Query (simple field)
    Optional<calsession> findBySessionId(String sessionId);
    
    // ✅ ALL other methods with @Query:
    
    @Query("SELECT cs FROM calsession cs WHERE cs.doctor.userId = :doctorId AND cs.patient.userId = :patientId AND cs.status = :status")
    Optional<calsession> findByDoctorIdAndPatientIdAndStatus(
        @Param("doctorId") Long doctorId, 
        @Param("patientId") Long patientId, 
        @Param("status") calsession.CallStatus status
    );
    
    @Query("SELECT cs FROM calsession cs WHERE cs.doctor.userId = :doctorId AND cs.status = :status")
    Optional<calsession> findByDoctorIdAndStatus(
        @Param("doctorId") Long doctorId, 
        @Param("status") calsession.CallStatus status
    );
    
    @Query("SELECT cs FROM calsession cs WHERE cs.patient.userId = :patientId AND cs.status = :status")
    Optional<calsession> findByPatientIdAndStatus(
        @Param("patientId") Long patientId, 
        @Param("status") calsession.CallStatus status
    );
    
    @Query("SELECT cs FROM calsession cs WHERE cs.doctor.userId = :doctorId ORDER BY cs.startedAt DESC")
    List<calsession> findByDoctorIdOrderByStartedAtDesc(@Param("doctorId") Long doctorId);
    
    @Query("SELECT cs FROM calsession cs WHERE cs.patient.userId = :patientId ORDER BY cs.startedAt DESC")
    List<calsession> findByPatientIdOrderByStartedAtDesc(@Param("patientId") Long patientId);
    
    @Query("SELECT cs FROM calsession cs WHERE cs.status = :status AND cs.startedAt < :startedAt")
    List<calsession> findByStatusAndStartedAtBefore(
        @Param("status") calsession.CallStatus status, 
        @Param("startedAt") java.time.LocalDateTime startedAt
    );
    
    // Additional helpful queries
    @Query("SELECT cs FROM calsession cs WHERE (cs.doctor.userId = :userId OR cs.patient.userId = :userId) AND cs.status = 'ACTIVE'")
    Optional<calsession> findActiveCallByUserId(@Param("userId") Long userId);
    
    @Query("SELECT cs FROM calsession cs WHERE cs.doctor.userId = :userId OR cs.patient.userId = :userId ORDER BY cs.startedAt DESC")
    List<calsession> findAllCallsByUserId(@Param("userId") Long userId);
    
    List<calsession> findAllByOrderByStartedAtDesc();
    
   
    
}
