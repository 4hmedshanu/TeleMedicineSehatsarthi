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


import com.telemedicine.allentity.appointments;
import com.telemedicine.allservices_implementation.appointment_imple;

@RestController
@RequestMapping("/appointments")
public class appointments_controller {
	
	@Autowired
	appointment_imple appointment_servies;
	
	@GetMapping
	public List<appointments> getall() {
		return this.appointment_servies.get_allappoinments();
	}
	
	
	
	@GetMapping("/singlbyid/{id}")
	public appointments getsingle(@PathVariable Long id) {
		return this.appointment_servies.get_single_appoinments(id);
	}
	
	@PostMapping("/create/{pationsid}/{doctorid}")
	public appointments createSingle(@RequestBody appointments appointments , @PathVariable Long pationsid, @PathVariable Long doctorid) {
	    return this.appointment_servies.book_appoinments(appointments, pationsid, doctorid);
	}
	
	@PutMapping("/{id}")
	public appointments appointmentsupdate(@RequestBody  appointments appointments, @PathVariable Long id) {
		return this.appointment_servies.update_appoinments(appointments, id);
	}
	
	@DeleteMapping
	public boolean deleteall() {
		return this.appointment_servies.Delete_all_appoinments();
	}
	
	@DeleteMapping("/{id}")
	public appointments deletesingle(@PathVariable long id) {
		return this.appointment_servies.Delete_single_appoinments(id);
	}
	
	
	@GetMapping("/pationtid/{id}")
	public List<appointments> getAppointmentsbypationid(@PathVariable Long id){
		return this.appointment_servies.getAppointmentsbypation(id);
	}
	
	
	
	

}
