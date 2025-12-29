package com.telemedicine.allController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telemedicine.allentity.patient;
import com.telemedicine.allservices_implementation.patient_imple;

@RestController
@RequestMapping("/patient")
public class patient_controller {
	
	@Autowired
	patient_imple patient_services;
	
	
	@GetMapping
	public List<patient> getall() {
		return this.patient_services.Read_all_patient();
	}
	
	@GetMapping("/singlbyid/{id}")
	public patient getsingle(@PathVariable Long id) {
		return this.patient_services.Read_single_patient(id);
	}
	
	@PostMapping("/create/{id}")
	public patient createSingle(@RequestBody patient patient , @PathVariable Long id) {
	    return this.patient_services.Create_patient(patient, id);
	}
	
	@PutMapping("/{id}")
	public patient patientupdate(@RequestBody  patient patient , @PathVariable Long id) {
		return this.patient_services.update_patient(patient, id);
	}
	
	@DeleteMapping
	public boolean deleteall() {
		return this.patient_services.Delete_all_patient();
	}
	
	@DeleteMapping("/{id}")
	public patient deletesingle(@PathVariable long id) {
		return this.patient_services.Delete_single_patient(id);
	}
	
	@GetMapping("/byuser/{email}")
	public patient getsinglebyuser(@PathVariable String email) {
		return this.patient_services.getsinglebyuser(email);
	}
	
	

}
