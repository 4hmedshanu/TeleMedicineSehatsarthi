package com.telemedicine.allservicesprovider;

import java.util.List;

import com.telemedicine.allentity.hospital;

public interface hospital_interface {
	hospital Createhospital(hospital hospital);
	List<hospital> Read_all_hospital();
	hospital Read_single_hospital(Long id);
	hospital update_hospital(hospital hosp, Long id);
	hospital Delete_single_hospital(Long id);
	boolean Delete_all_hospital();
	hospital Read_by_username(String email);
	

}
