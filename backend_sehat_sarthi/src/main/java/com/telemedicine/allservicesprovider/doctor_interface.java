package com.telemedicine.allservicesprovider;

import java.util.List;

import com.telemedicine.allentity.Doctor;



public interface doctor_interface {
	
	Doctor Create_doctor(Doctor doctor, Long id);
	List<Doctor> Read_all_doctor();
	Doctor Read_single_doctor(Long id);
	Doctor update_doctor(Doctor doctor, Long id);
	Doctor Delete_single_doctor(Long id);
	boolean Delete_all_doctor();

}
