package com.telemedicine.allservices_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telemedicine.allentity.ChatMessage;
import com.telemedicine.allservicesprovider.chatmassage_interface;

@Service
public class chatmassege_imple implements chatmassage_interface {

	@Override
	public List<ChatMessage> get_allchart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChatMessage get_single_ChatMessage(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChatMessage delete_single_ChatMessage(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Delete_all_Chat() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
