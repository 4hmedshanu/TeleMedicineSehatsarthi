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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telemedicine.allentity.user;
import com.telemedicine.allservices_implementation.user_imple;

@RestController
@RequestMapping("/user")
public class user_controller {
	
	@Autowired
	user_imple user_services;
	
	@GetMapping
	public List<user> getall() {
		return this.user_services.Read_all_user();
	}
	
	@GetMapping("/singlbyid/{id}")
	public user getsingle(@PathVariable Long id) {
		return this.user_services.Read_single_user(id);
	}
	@GetMapping("/username/{email}")
	public user getusernameby(@PathVariable String email) {
		return this.user_services.Read_by_username(email);
	}
	
	@PostMapping
	public user createSingle(@RequestBody user user) {
	    return this.user_services.Createuser(user);
	}
	
	
	@PutMapping("/{id}")
	public user userupdate(@RequestBody user user , @PathVariable Long id) {
		
		return this.user_services.update_user(user, id);
	}
	
	@DeleteMapping
	public boolean deleteall() {
		return this.user_services.Delete_all_user();
	}
	
	@DeleteMapping("/{id}")
	public user deletesingle(@PathVariable long id) {
		return this.user_services.Delete_single_user(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
