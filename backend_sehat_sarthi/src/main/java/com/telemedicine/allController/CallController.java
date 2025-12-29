package com.telemedicine.allController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telemedicine.websocket.CallServices;

@RestController
@RequestMapping("/api/calls")
public class CallController {
	
	@Autowired
	  private  CallServices callService;
	    
	    public CallController(CallServices callService) {
	        this.callService = callService;
	    }
	    
	    
	    @PostMapping("/start")
	    public Map<String, String> startCall(@RequestBody StartCallRequest request) {
	    	 String sessionId = callService.startCall(request.getDoctorId(), request.getPatientId());
	        return Map.of("sessionId", sessionId);
	    }
	    
	    @PostMapping("/end")
	    public void endCall(@RequestBody EndCallRequest request) {
	        callService.endCall(request.getSessionId());
	    }
	    
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

}
