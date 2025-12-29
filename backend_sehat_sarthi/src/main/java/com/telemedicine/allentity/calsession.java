package com.telemedicine.allentity;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "callseesion")
public class calsession {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "doctor_id")
	    private user doctor;
	    
	    @ManyToOne
	    @JoinColumn(name = "patient_id")
	    private user patient;
	    
	    // ✅ ADD RECEIVER
	    @ManyToOne
	    @JoinColumn(name = "receiver_id")
	    private user receiver;
	    
	    // ✅ ADD SENDER
	    @ManyToOne
	    @JoinColumn(name = "sender_id")
	    private user sender;
	    
	    private String sessionId;
	    private LocalDateTime startedAt;
	    private LocalDateTime endedAt;
	    private Integer duration;
	    private String content;
	    
	    @Enumerated(EnumType.STRING)
	    private CallStatus status;
	    
	    // Constructors
	    public calsession() {}
	    
	    public calsession(user doctor, user patient, String sessionId, CallStatus status) {
	        this.doctor = doctor;
	        this.patient = patient;
	        this.sender = doctor;  // Set doctor as sender
	        this.receiver = patient; // Set patient as receiver
	        this.sessionId = sessionId;
	        this.status = status;
	        this.startedAt = LocalDateTime.now();
	        this.content = "Call started between doctor and patient";
	    }
	    
	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }
	    
	    public user getDoctor() { return doctor; }
	    public void setDoctor(user doctor) { 
	        this.doctor = doctor; 
	        this.sender = doctor; // Auto-set sender as doctor
	    }
	    
	    public user getPatient() { return patient; }
	    public void setPatient(user patient) { 
	        this.patient = patient; 
	        this.receiver = patient; // Auto-set receiver as patient
	    }
	    
	    public user getReceiver() { return receiver; }
	    public void setReceiver(user receiver) { this.receiver = receiver; }
	    
	    public user getSender() { return sender; }
	    public void setSender(user sender) { this.sender = sender; }
	    
	    public String getSessionId() { return sessionId; }
	    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
	    
	    public LocalDateTime getStartedAt() { return startedAt; }
	    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }
	    
	    public LocalDateTime getEndedAt() { return endedAt; }
	    public void setEndedAt(LocalDateTime endedAt) { this.endedAt = endedAt; }
	    
	    public Integer getDuration() { return duration; }
	    public void setDuration(Integer duration) { this.duration = duration; }
	    
	    public String getContent() { return content; }
	    public void setContent(String content) { this.content = content; }
	    
	    public CallStatus getStatus() { return status; }
	    public void setStatus(CallStatus status) { this.status = status; }
	    
	    public enum CallStatus {
	        ACTIVE, ENDED, FAILED
	    }
	    
	   
	    
	

}
