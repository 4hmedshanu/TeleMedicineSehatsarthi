package com.telemedicine.allservicesprovider;

import java.util.List;

import com.telemedicine.allentity.appointments;



public interface appointment_interface {
	
	appointments   book_appoinments(appointments  appoin, Long pationsid, Long Doctorid);
	List<appointments> get_allappoinments();
	appointments get_single_appoinments(Long id);
	appointments update_appoinments(appointments appoinments, Long id);
	appointments Delete_single_appoinments(Long id);
	boolean Delete_all_appoinments();
	

}
