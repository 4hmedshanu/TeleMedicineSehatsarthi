package com.telemedicine.entity;



public class ChatMessage {
	
	    Long id;
	    
		 private user sender;
		  private user receiver;
		   private String content;
		   private String timestamp;
		   public Long getId() {
			   return id;
		   }
		   public void setId(Long id) {
			   this.id = id;
		   }
		   public user getSender() {
			   return sender;
		   }
		   public void setSender(user sender) {
			   this.sender = sender;
		   }
		   public user getReceiver() {
			   return receiver;
		   }
		   public void setReceiver(user receiver) {
			   this.receiver = receiver;
		   }
		   public String getContent() {
			   return content;
		   }
		   public void setContent(String content) {
			   this.content = content;
		   }
		   public String getTimestamp() {
			   return timestamp;
		   }
		   public void setTimestamp(String timestamp) {
			   this.timestamp = timestamp;
		   }
		   public ChatMessage(Long id, user sender, user receiver, String content, String timestamp) {
			super();
			this.id = id;
			this.sender = sender;
			this.receiver = receiver;
			this.content = content;
			this.timestamp = timestamp;
		   }
		   public ChatMessage() {
			super();
			// TODO Auto-generated constructor stub
		   }
		   
		   

		   
		   
}
