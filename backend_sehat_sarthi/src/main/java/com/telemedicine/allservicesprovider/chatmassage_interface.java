package com.telemedicine.allservicesprovider;

import java.util.List;

import com.telemedicine.allentity.ChatMessage;



public interface chatmassage_interface {
	
	
	List<ChatMessage> get_allchart();
	ChatMessage get_single_ChatMessage(Long id);
	ChatMessage delete_single_ChatMessage(Long id);
	boolean Delete_all_Chat();
	

}
