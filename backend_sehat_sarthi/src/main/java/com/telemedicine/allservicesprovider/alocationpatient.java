package com.telemedicine.allservicesprovider;

import java.util.List;

import com.telemedicine.allentity.allocatepatient;

public interface alocationpatient {
	
	allocatepatient createdAllocatepatient(allocatepatient all, Long patientid, Long doctorid);
	List<allocatepatient> getallocatepatient();
	
	List<allocatepatient> getallocatepatientbydr(Long id);
	
	

}
