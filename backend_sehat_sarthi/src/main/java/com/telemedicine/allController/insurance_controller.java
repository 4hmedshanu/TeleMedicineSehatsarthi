package com.telemedicine.allController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telemedicine.allservices_implementation.insurance_imple;

@RestController
@RequestMapping("/insurance")
public class insurance_controller {
	
	@Autowired
	insurance_imple insurance_servies;
	
	
	
	

}
