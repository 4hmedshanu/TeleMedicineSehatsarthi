package com.telemedicine.allentity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class allocatepatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "patient_id" )  // Each patient only once
    private patient patient;

    // Many patients can be assigned to one doctor
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")  // Foreign key column
    private Doctor doctor;
    
    private boolean flag;

    // Each allocation is linked to one patient
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public patient getPatient() {
		return patient;
	}

	public void setPatient(patient patient) {
		this.patient = patient;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	

	public allocatepatient(Long id, com.telemedicine.allentity.patient patient, Doctor doctor, boolean flag) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.flag = flag;
	}

	public allocatepatient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
    

}
