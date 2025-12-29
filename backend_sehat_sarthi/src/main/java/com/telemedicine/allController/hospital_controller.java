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


import com.telemedicine.allentity.hospital;
import com.telemedicine.allservices_implementation.hospital_imple;

@RestController
@RequestMapping("/hospital")
public class hospital_controller {
	
	@Autowired
	hospital_imple hospital_services;
	
	
	@GetMapping
	public List<hospital> getall() {
		return this.hospital_services.Read_all_hospital();
	}
	
	@GetMapping("/singlbyid/{id}")
	public hospital getsingle(@PathVariable Long id) {
		return this.hospital_services.Read_single_hospital(id);
	}
	
	@PostMapping("/create/{id}")
	public hospital createSingle(@RequestBody hospital hospital , @PathVariable Long id) {
	    return this.hospital_services.Createhospital(hospital);
	}
	
	@PutMapping("/{id}")
	public  hospital hospitalupdate(@RequestBody  hospital hospital, @PathVariable Long id) {
		return this.hospital_services.update_hospital(hospital, id);
	}
	
	@DeleteMapping
	public boolean deleteall() {
		return this.hospital_services.Delete_all_hospital();
	}
	
	@DeleteMapping("/{id}")
	public hospital deletesingle(@PathVariable long id) {
		return this.hospital_services.Delete_single_hospital(id);
	}
	
	
	
	
}
