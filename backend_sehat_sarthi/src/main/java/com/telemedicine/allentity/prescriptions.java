package com.telemedicine.allentity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class prescriptions {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private patient patient;

    private String medicationName;
    private String dosage;
    private String frequency;
    private String duration;

    @Column(length = 1000)
    private String instructions;

    private Date prescribedDate;

	public Long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Long prescriptionId) {
		this.prescriptionId = prescriptionId;
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

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Date getPrescribedDate() {
		return prescribedDate;
	}

	public void setPrescribedDate(Date prescribedDate) {
		this.prescribedDate = prescribedDate;
	}

	public prescriptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public prescriptions(Long prescriptionId, Doctor doctor, com.telemedicine.allentity.patient patient,
			String medicationName, String dosage, String frequency, String duration, String instructions,
			Date prescribedDate) {
		super();
		this.prescriptionId = prescriptionId;
		this.doctor = doctor;
		this.patient = patient;
		this.medicationName = medicationName;
		this.dosage = dosage;
		this.frequency = frequency;
		this.duration = duration;
		this.instructions = instructions;
		this.prescribedDate = prescribedDate;
	}
    
    

}
