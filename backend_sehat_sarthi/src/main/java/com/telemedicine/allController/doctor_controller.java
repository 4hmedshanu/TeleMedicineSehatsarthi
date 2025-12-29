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

import com.telemedicine.allentity.Doctor;
import com.telemedicine.allservices_implementation.doctor_imple;

@RestController
@RequestMapping("/doctor")
public class doctor_controller {
	
	@Autowired
	doctor_imple doctor_services;
	
	@GetMapping
	public List<Doctor> getall() {
		return this.doctor_services.Read_all_doctor();
	}
	
	@GetMapping("/singlbyid/{id}")
	public Doctor getsingle(@PathVariable Long id) {
		return this.doctor_services.Read_single_doctor(id);
	}
	
	@PostMapping("/create/{id}")
	public Doctor createSingle(@RequestBody Doctor Doctor , @PathVariable Long id) {
	    return this.doctor_services.Create_doctor(Doctor, id);
	}
	
	@PutMapping("/{id}")
	public Doctor doctorupdate(@RequestBody  Doctor Doctor, @PathVariable Long id) {
		return this.doctor_services.update_doctor(Doctor, id);
	}
	
	@DeleteMapping
	public boolean deleteall() {
		return this.doctor_services.Delete_all_doctor();
	}
	
	@DeleteMapping("/{id}")
	public Doctor deletesingle(@PathVariable long id) {
		return this.doctor_services.Delete_single_doctor(id);
	}
	
	
	@GetMapping("/singlbyemail/{email}")
	public Doctor getdoctor(@PathVariable String email) {
		return this.doctor_services.getdoctorbyuser(email);
		
	}
	
	

}
