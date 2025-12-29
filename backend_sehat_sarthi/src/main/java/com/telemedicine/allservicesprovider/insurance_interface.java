package com.telemedicine.allservicesprovider;

import java.util.List;


import com.telemedicine.allentity.insurance;

public interface insurance_interface {
	
	insurance Create_insurance(insurance insurance);
	List<insurance> Read_all_insurance();
	insurance Read_single_insurance(Long id);
	insurance update_insurance(insurance insurance, Long id);
	insurance Delete_single_insurance(Long id);
	boolean Delete_all_insurance();

}
