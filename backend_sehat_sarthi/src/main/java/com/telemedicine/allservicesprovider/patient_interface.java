package com.telemedicine.allservicesprovider;

import java.util.List;

import com.telemedicine.allentity.patient;



public interface patient_interface {
	
	patient Create_patient(patient patient, Long id);
	List<patient> Read_all_patient();
	patient Read_single_patient(Long id);
	patient update_patient(patient patient, Long id);
	patient Delete_single_patient(Long id);
	boolean Delete_all_patient();
//	patient Read_by_username(String email);
	

}
