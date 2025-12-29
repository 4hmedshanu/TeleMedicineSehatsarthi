package com.telemedicine.allController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telemedicine.allentity.allocatepatient;
import com.telemedicine.allservices_implementation.allocatepatient_imple;

@RestController
@RequestMapping("/alocatepatient")
public class allocationpatien_controller {
	
	
	@Autowired
	allocatepatient_imple allocatepatient;
	
	
	@PostMapping("/{patient_id}/{doctor_id}")
	public allocatepatient createdAllocatepatient(@RequestBody allocatepatient all, @PathVariable Long patient_id, @PathVariable Long doctor_id) {
		
		return allocatepatient.createdAllocatepatient(all,patient_id, doctor_id);
	}
	
	
	@GetMapping
	public List<allocatepatient> getallocatepatient(){
		return this.allocatepatient.getallocatepatient();
	}
	
	@GetMapping("/{id}")
	public List<allocatepatient> getallocatepatientbydr(@PathVariable Long id){
		return this.allocatepatient.getallocatepatientbydr(id);
	}
	
	@GetMapping("/patient/{id}")
	public allocatepatient getallbypatient(@PathVariable Long id) {
		return this.allocatepatient.getallbypatient(id);
	}
	
	@DeleteMapping
	public boolean deleteall() {
		this.allocatepatient.deleteall();
		return true;
	}
	
	
}
