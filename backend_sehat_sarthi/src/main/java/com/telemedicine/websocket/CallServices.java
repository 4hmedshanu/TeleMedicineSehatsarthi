package com.telemedicine.websocket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.*;
import com.telemedicine.allrepository.callsession_repo;
import com.telemedicine.allrepository.user_repo;

@Service
public class CallServices {

	@Autowired
	private  callsession_repo callSessionRepository;
	
	@Autowired
	private  user_repo userRepository;
	
	public String startCall(Long doctorId, Long patientId) {
    // Validate users exist
    Optional<user> doctorOpt = userRepository.findById(doctorId);
    Optional<user> patientOpt = userRepository.findById(patientId);

    if (doctorOpt.isEmpty() || patientOpt.isEmpty()) {
        throw new IllegalArgumentException("Invalid doctor or patient ID");
    }

    user doctor = doctorOpt.get();
    user patient = patientOpt.get();

    // Check if there's already an active call
    Optional<calsession> activeCall = callSessionRepository
            .findByDoctorIdAndPatientIdAndStatus(doctorId, patientId, calsession.CallStatus.ACTIVE);
    
    if (activeCall.isPresent()) {
        throw new IllegalStateException("There is already an active call between these users");
    }

    // Create new call session with ALL fields
    calsession callSession = new calsession();
    callSession.setDoctor(doctor);
    callSession.setPatient(patient);
    callSession.setSender(doctor);    // Doctor is sender
    callSession.setReceiver(patient); // Patient is receiver
    callSession.setSessionId(generateSessionId());
    callSession.setStartedAt(LocalDateTime.now());
    callSession.setStatus(calsession.CallStatus.ACTIVE);
    callSession.setContent("Call started between " + doctor.getName() + " and " + patient.getName());
    
    calsession savedSession = callSessionRepository.save(callSession);
    
    return savedSession.getSessionId();
}

    /**
     * End an active call session
     */
    public void endCall(String sessionId) {
        Optional<calsession> callSessionOpt = callSessionRepository.findBySessionId(sessionId);
        
        if (callSessionOpt.isPresent()) {
        	calsession callSession = callSessionOpt.get();
            
            if (callSession.getStatus() == calsession.CallStatus.ACTIVE) {
                callSession.setStatus(calsession.CallStatus.ENDED);
                callSession.setEndedAt(LocalDateTime.now());
                
                // Calculate call duration in seconds
                if (callSession.getStartedAt() != null && callSession.getEndedAt() != null) {
                    long duration = java.time.Duration.between(
                        callSession.getStartedAt(), callSession.getEndedAt()
                    ).getSeconds();
                    callSession.setDuration((int) duration);
                }
                
                callSessionRepository.save(callSession);
            }
        } else {
            throw new IllegalArgumentException("Call session not found: " + sessionId);
        }
    }

    /**
     * Mark call as failed
     */
    public void markCallAsFailed(String sessionId) {
        Optional<calsession> callSessionOpt = callSessionRepository.findBySessionId(sessionId);
        
        if (callSessionOpt.isPresent()) {
        	calsession callSession = callSessionOpt.get();
            callSession.setStatus(calsession.CallStatus.FAILED);
            callSession.setEndedAt(LocalDateTime.now());
            callSessionRepository.save(callSession);
        }
    }

    /**
     * Get call session details
     */
    public Optional<calsession> getCallSession(String sessionId) {
        return callSessionRepository.findBySessionId(sessionId);
    }

    /**
     * Get active calls for a user
     */
    public Optional<calsession> getActiveCallForUser(Long userId) {
        // Check both as doctor and as patient
        Optional<calsession> asDoctor = callSessionRepository
                .findByDoctorIdAndStatus(userId, calsession.CallStatus.ACTIVE);
        
        if (asDoctor.isPresent()) {
            return asDoctor;
        }
        
        return callSessionRepository.findByPatientIdAndStatus(userId, calsession.CallStatus.ACTIVE);
    }

    /**
     * Generate unique session ID
     */
    private String generateSessionId() {
        return "call_" + UUID.randomUUID().toString().substring(0, 8) + "_" + System.currentTimeMillis();
    }

    /**
     * Validate if user can join the call session
     */
    public boolean canUserJoinCall(String sessionId, Long userId) {
        Optional<calsession> callSessionOpt = callSessionRepository.findBySessionId(sessionId);
        
        if (callSessionOpt.isPresent()) {
            calsession callSession = callSessionOpt.get();
            
            // Safe null checks
            Long doctorId = (callSession.getDoctor() != null) ? callSession.getDoctor().getUserId(): null;
            Long patientId = (callSession.getPatient() != null) ? callSession.getPatient().getUserId() : null;
            
            return userId.equals(doctorId) || userId.equals(patientId);
        }
        
        return false;
    }

    /**
     * Get call history for a user
     */
    public List<calsession> getCallHistory(Long userId) {
        List<calsession> asDoctor = callSessionRepository.findByDoctorIdOrderByStartedAtDesc(userId);
        List<calsession> asPatient = callSessionRepository.findByPatientIdOrderByStartedAtDesc(userId);
        
        List<calsession> allCalls = new ArrayList<>();
        allCalls.addAll(asDoctor);
        allCalls.addAll(asPatient);
        
        // Sort by start time descending
        allCalls.sort((c1, c2) -> c2.getStartedAt().compareTo(c1.getStartedAt()));
        
        return allCalls;
    }
	
	
}
