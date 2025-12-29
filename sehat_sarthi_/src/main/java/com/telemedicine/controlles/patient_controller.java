package com.telemedicine.controlles;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telemedicine.backendrepository.backend_services;
import com.telemedicine.entity.Doctor;
import com.telemedicine.entity.appointments;
import com.telemedicine.entity.patient;



@Controller
@RequestMapping("/Patient")
public class patient_controller {
	
	@Autowired
	backend_services services;
	
	@GetMapping
	public String Patient(Principal principal , Model  mo) {
		String email=principal.getName();
		patient patient=this.services.getsinglepatientbyuser(email);
		
		List<appointments>  appointment=this.services.getAppointmentsbypationid(patient.getPatientId());
		 mo.addAttribute("patient",patient);
		 mo.addAttribute("ap",appointment);
		
		return "Patient_page";
	}
	

	
	
	

}
