package com.telemedicine.backendrepository;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.telemedicine.entity.ChatMessage;
import com.telemedicine.entity.Doctor;
import com.telemedicine.entity.allocatepatient;
import com.telemedicine.entity.appointments;
import com.telemedicine.entity.patient;
import com.telemedicine.entity.user;


@FeignClient(name = "backend-sehat-sarthi")
public interface backend_services {
	
	@GetMapping("/patient/singlbyid/{id}")
	public patient getsinglepatient(@PathVariable Long id);
	
	@PostMapping("/user")
	public user createSingle(@RequestBody user user);
	
	@GetMapping("/user/username/{email}")
	public user getusernameby(@PathVariable String email);
	
	@GetMapping("/user/singlbyid/{id}")
	public user getsingleuserbyid(@PathVariable Long id);
	
	
	@GetMapping("/patient/byuser/{email}")
	public patient getsinglepatientbyuser(@PathVariable String email);
	
	@PostMapping("/patient/create/{id}")
	public patient createSinglepatient(@RequestBody patient patient , @PathVariable Long id) ;
	
	
	@GetMapping("/doctor")
	public List<Doctor> getalldoctor(); 
	
	
	@GetMapping("/doctor/singlbyid/{id}")
	public Doctor getsingledoctor(@PathVariable Long id);
	
	@PostMapping("/doctor/create/{id}")
	public Doctor createSingledoctor(@RequestBody Doctor Doctor , @PathVariable Long id);
	
	
	
	
	@PostMapping("/sendmessage")
	public ChatMessage sendMessage(ChatMessage message);
	
	@GetMapping("/doctor/singlbyemail/{email}")
	public Doctor getdoctor(@PathVariable String email);
	
	
	
	@GetMapping("/alocatepatient/{id}")
    public	List<allocatepatient> getallocatepatientbydr(@PathVariable Long id);
    
	@PostMapping("/alocatepatient/{patient_id}/{doctor_id}")
	public allocatepatient createdAllocatepatient(@RequestBody allocatepatient all, @PathVariable Long patient_id, @PathVariable Long doctor_id);
	
	@GetMapping("/alocatepatient/patient/{id}")
	public allocatepatient getallbypatient(@PathVariable Long id);
	
	
    @PostMapping("/api/calls/start")
    public Map<String, String> startCall(@RequestBody StartCallRequest request);
    
    @PostMapping("/api/calls/end")
    public void endCall(@RequestBody EndCallRequest request);
    
    
    public static class StartCallRequest {
        private Long doctorId;
        private Long patientId;
        // Getters and setters
		public Long getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(Long doctorId) {
			this.doctorId = doctorId;
		}
		public Long getPatientId() {
			return patientId;
		}
		public void setPatientId(Long patientId) {
			this.patientId = patientId;
		}
        
        
    }
    
    public static class EndCallRequest {
        private String sessionId;
        // Getters and setters

		public String getSessionId() {
			return sessionId;
		}

		public void setSessionId(String sessionId) {
			this.sessionId = sessionId;
		}
        
        
    }
    
    
    @GetMapping("/appointments/pationtid/{id}")
	public List<appointments> getAppointmentsbypationid(@PathVariable Long id);
    
    
    
	
	
	
	
	
	
	
}
