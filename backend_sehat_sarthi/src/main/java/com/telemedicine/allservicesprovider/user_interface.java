package com.telemedicine.allservicesprovider;



import java.util.List;

import com.telemedicine.allentity.user;

public interface user_interface {
	
	user Createuser(user user);
	List<user> Read_all_user();
	user Read_single_user(Long id);
	user update_user(user user, Long id);
	user Delete_single_user(Long id);
	boolean Delete_all_user();
	user Read_by_username(String email);
	
}
