package com.telemedicine.controlles;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.telemedicine.backendrepository.backend_services;
import com.telemedicine.entity.Doctor;
import com.telemedicine.entity.allocatepatient;
import com.telemedicine.entity.patient;

@Controller
public class chating_controller {
	@Autowired
	backend_services services;
	
	@GetMapping("/connect/{id}/{fixid}")
	public String connectpage(@PathVariable Long id, @PathVariable int fixid, Model mo, Principal princip) {
		
		if(fixid==1) {
			// doctor
			patient patien=this.services.getsinglepatient(id);
			mo.addAttribute("receiver",patien);
			String name =princip.getName();
			Doctor dr=this.services.getdoctor(name);
			mo.addAttribute("sender", dr);
		}
		
		else{
			// patient
	   allocatepatient alsd=new allocatepatient();
		Doctor dr=this.services.getsingledoctor(id);
		mo.addAttribute("receiver",dr);
		String name =princip.getName();
		patient patient=this.services.getsinglepatientbyuser(name);
		mo.addAttribute("sender", patient);
		allocatepatient allo=this.services.getallbypatient(patient.getPatientId());
		if(allo==null) {
			this.services.createdAllocatepatient(alsd,patient.getPatientId(), dr.getDoctorId());
		}
			
		}
		return "chatingpage";
	}

}
