package com.telemedicine.allentity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
	 private user sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
	  private user receiver;
	   private String content;
	   private LocalDateTime sentAt;
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
	   
	   public LocalDateTime getSentAt() {
		return sentAt;
	   }
	   public void setSentAt(LocalDateTime sentAt) {
		   this.sentAt = sentAt;
	   }
	   
	   
	   public ChatMessage(Long id, user sender, user receiver, String content, LocalDateTime sentAt) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.sentAt = sentAt;
	}
	   public ChatMessage() {
		super();
		// TODO Auto-generated constructor stub
	   }
	   
	   

}
