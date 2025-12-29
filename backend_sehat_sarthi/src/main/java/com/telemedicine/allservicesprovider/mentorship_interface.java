package com.telemedicine.allservicesprovider;

import java.util.List;

import com.telemedicine.allentity.mentorship;



public interface mentorship_interface {
	
	mentorship Create_mentorship(mentorship mentorship, Long patient_id, Long doctor_id);
	List<mentorship> Read_all_mentorship();
	mentorship Read_single_mentorship(Long id);
	mentorship update_mentorship(mentorship mentorship, Long id);
	mentorship Delete_single_mentoship(Long id);
	boolean Delete_all_mentoship();
	
}
