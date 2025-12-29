package com.telemedicine.entity;



public class allocatepatient {
    private Long id;
    private Doctor doctor; 
    private patient patient;
    private boolean flag;

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

	
	

	public allocatepatient(Long id, Doctor doctor, com.telemedicine.entity.patient patient, boolean flag) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.flag = flag;
	}


	public allocatepatient() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    

}
