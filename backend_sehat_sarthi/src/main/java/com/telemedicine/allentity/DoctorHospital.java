package com.telemedicine.allentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DoctorHospital {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorHospital;
	
	
   
    private Long doctorId;

   
    private Long hospitalId;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	


	public Long getDoctorHospital() {
		return doctorHospital;
	}

	public void setDoctorHospital(Long doctorHospital) {
		this.doctorHospital = doctorHospital;
	}

	
	
	public DoctorHospital(Long doctorHospital, Long doctorId, Long hospitalId) {
		super();
		this.doctorHospital = doctorHospital;
		this.doctorId = doctorId;
		this.hospitalId = hospitalId;
	}

	public DoctorHospital() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    

}
