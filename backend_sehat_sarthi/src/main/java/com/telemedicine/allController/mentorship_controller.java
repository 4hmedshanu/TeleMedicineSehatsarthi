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

import com.telemedicine.allentity.mentorship;
import com.telemedicine.allservices_implementation.mentorship_imple;

@RestController
@RequestMapping("/mentorship")
public class mentorship_controller {
	
	@Autowired
	mentorship_imple mentorship_imple;
	
	@GetMapping
	public List<mentorship> getall() {
		return this.mentorship_imple.Read_all_mentorship();
	}
	
	@GetMapping("/singlbyid/{id}")
	public mentorship getsingle(@PathVariable Long id) {
		return this.mentorship_imple.Read_single_mentorship(id);
	}
	
	@PostMapping("/create/{id}")
	public mentorship createSingle(@RequestBody mentorship mentorship , @PathVariable Long praticeid, @PathVariable Long Doctorid) {
	    return this.mentorship_imple.Create_mentorship(mentorship, praticeid, Doctorid);
	}
	
	@PutMapping("/{id}")
	public mentorship mentoshipupdate(@RequestBody  mentorship mentorship, @PathVariable Long id) {
		return this.mentorship_imple.update_mentorship(mentorship, id);
	}
	
	@DeleteMapping
	public boolean deleteall() {
		return this.mentorship_imple.Delete_all_mentoship();
	}
	
	@DeleteMapping("/{id}")
	public mentorship deletesingle(@PathVariable long id) {
		return this.mentorship_imple.Delete_single_mentoship(id);
	}
	
	
	
	

}
