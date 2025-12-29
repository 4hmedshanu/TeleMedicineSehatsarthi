package com.telemedicine.websocket;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.telemedicine.allentity.SignalMessage;

@Controller
public class SignalingController {
	
	private final SimpMessagingTemplate messagingTemplate;
	
	
	  public SignalingController(SimpMessagingTemplate messagingTemplate) {
	        this.messagingTemplate = messagingTemplate;
	    }
	  
	  @MessageMapping("/call.offer")
	    public void handleOffer(SignalMessage message, Principal principal) {
	        // Route OFFER to specific user
	        messagingTemplate.convertAndSendToUser(
	            message.getTargetUser(), 
	            "/queue/call", 
	            message
	        );
	    }
	  
	  @MessageMapping("/call.answer")
	    public void handleAnswer(SignalMessage message, Principal principal) {
	        message.setFromUser(principal.getName());
	        System.out.println("ANSWER from " + principal.getName() + " to " + message.getTargetUser());
	        
	        messagingTemplate.convertAndSendToUser(
	            message.getTargetUser(), 
	            "/queue/call", 
	            message
	        );
	    }
	  
	  
	  @MessageMapping("/call.ice-candidate")
	    public void handleIceCandidate(SignalMessage message, Principal principal) {
	        message.setFromUser(principal.getName());
	        System.out.println("ICE_CANDIDATE from " + principal.getName() + " to " + message.getTargetUser());
	        
	        messagingTemplate.convertAndSendToUser(
	            message.getTargetUser(), 
	            "/queue/call", 
	            message
	        );
	    }
	  
	  @MessageMapping("/call.start")
	    @SendToUser("/queue/call")
	    public SignalMessage handleCallStart(SignalMessage message, Principal principal) {
	        message.setFromUser(principal.getName());
	        message.setType("CALL_START");
	        System.out.println("CALL_START from " + principal.getName() + " to " + message.getTargetUser());
	        return message;
	    }
	  
	  
	  @MessageMapping("/call.end")
	    @SendToUser("/queue/call")
	    public SignalMessage handleCallEnd(SignalMessage message, Principal principal) {
	        message.setFromUser(principal.getName());
	        message.setType("CALL_END");
	        System.out.println("CALL_END from " + principal.getName() + " to " + message.getTargetUser());
	        return message;
	    }
	  
	  
	        
	  
	  
	  

}
