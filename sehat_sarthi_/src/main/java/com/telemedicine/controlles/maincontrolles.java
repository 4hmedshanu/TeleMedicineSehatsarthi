package com.telemedicine.controlles;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telemedicine.backendrepository.backend_services;
import com.telemedicine.entity.user;
import com.telemedicine.entity.*;
@Controller
public class maincontrolles {
	
	@Autowired
	backend_services services;
	
	@GetMapping("/")
	public String homepage() {
		return "Home_Page";
	}
	
	
	@GetMapping("/Sign/{id}")
	public String Signup(@PathVariable Long id, Model mo) {
		mo.addAttribute("id",id);
		return "Signup_page";
	}
	
	@GetMapping("/Sign/regitration")
	public String regitration(@ModelAttribute user user, Model mo) {
		user ans=this.services.createSingle(user);
		mo.addAttribute("user",ans);
		if("Doctor".equals(ans.getRole())) {
			return "doctor_from";
		}
		
		return "pateint_form";
	}
	
	@GetMapping("/Sign/successful")
	public String Signsuccessful(@ModelAttribute patient p , @RequestParam ("patien") Long id) {
		    patient patien=this.services.createSinglepatient(p, id);
		    return "redirect:/loginpage";
	}
	
	@GetMapping("/Sign/successfuldoctor")
	@ResponseBody
	public String Signsuccessfuldoctor(@ModelAttribute Doctor d ,  @RequestParam ("docid") Long id) {
		Doctor doc= this.services.createSingledoctor(d, id);
		 return "redirect:/loginpage";
	}
	
	
	@GetMapping("/loginpage")
	public String loginpage() {
		return "Login_page";
	}
	
	@GetMapping("/Appointment")
	public String Mentoriship() {
		return "Mentorship_page";
	}
	
	@GetMapping("Appointment/successful")
	public String Appointmentsuccessfulpage() {
		int id=0;
		if(id==1) {
			return "invoice";
		}
		
		return "appointmentCard";
	}
	
	

	@GetMapping("/mentorship/{id}")
	@PreAuthorize("hasAnyRole('Doctor', 'Patient')")
	public String mentorshppage(Model mo, @PathVariable Long id, Principal prin) {
		String name =prin.getName();
		
		if(id==1) {
			Doctor dr=this.services.getdoctor(name);
			// doctor access karna chahata hai 
			List<allocatepatient> patient=this.services.getallocatepatientbydr(dr.getDoctorId());
			mo.addAttribute("patient",patient);
			mo.addAttribute("user",dr);
			}
		else {
			patient patient=this.services.getsinglepatientbyuser(name);
		 List<Doctor> doc=this.services.getalldoctor();
		 mo.addAttribute("dr",doc);
		 mo.addAttribute("user",patient);
		}
		System.out.println(name);
		return "Mentor_page";
	}
	
	
	@GetMapping("/Medicine_Delivery")	
	public String Medicine_Delivery() {
		return "delivery_app";
	}
	
	
	@GetMapping("/Nearbyhospital")	
	public String nearbyhospital() {
		return "nearbyHospital";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
