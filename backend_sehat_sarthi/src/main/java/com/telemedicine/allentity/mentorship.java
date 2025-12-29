package com.telemedicine.allentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class mentorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentorshipId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private String mentorshipDate;
    private String notes;
    
	public Long getMentorshipId() {
		return mentorshipId;
	}
	public void setMentorshipId(Long mentorshipId) {
		this.mentorshipId = mentorshipId;
	}
	public patient getPatient() {
		return patient;
	}
	public void setPatient(patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getMentorshipDate() {
		return mentorshipDate;
	}
	public void setMentorshipDate(String mentorshipDate) {
		this.mentorshipDate = mentorshipDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public mentorship(Long mentorshipId, com.telemedicine.allentity.patient patient, Doctor doctor,
			String mentorshipDate, String notes) {
		super();
		this.mentorshipId = mentorshipId;
		this.patient = patient;
		this.doctor = doctor;
		this.mentorshipDate = mentorshipDate;
		this.notes = notes;
	}
	public mentorship() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
