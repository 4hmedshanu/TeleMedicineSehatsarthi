package com.telemedicine.allservicesprovider;

import java.util.List;

import com.telemedicine.allentity.prescriptions;



public interface prescriptions_interface  {
	
	prescriptions Create_prescriptions(prescriptions prescriptions, Long patient_id, Long doctor_id);
	List<prescriptions> Read_all_prescriptions();
	prescriptions Read_single_prescriptions(Long id);
	prescriptions update_prescriptions(prescriptions prescipt, Long id);
	prescriptions Delete_single_prescriptions(Long id);
	boolean Delete_all_prescriptions();

}
