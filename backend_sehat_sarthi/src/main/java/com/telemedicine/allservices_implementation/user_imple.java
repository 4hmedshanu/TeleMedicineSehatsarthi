package com.telemedicine.allservices_implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.user;
import com.telemedicine.allrepository.user_repo;
import com.telemedicine.allservicesprovider.user_interface;

@Service

public class user_imple implements  user_interface{
	
	@Autowired
	user_repo userrepo;

	@Override
	public user Createuser(user user) {
		// TODO Auto-generated method stub
		return this.userrepo.save(user);
	}

	@Override
	public List<user> Read_all_user() {
		// TODO Auto-generated method stub
		return  this.userrepo.findAll();
	}

	@Override
	public user Read_single_user(Long id) {
		// TODO Auto-generated method stub
		return this.userrepo.findById(id).orElse(null);
	}

	@Override
	public user update_user(user user, Long id) {
		// TODO Auto-generated method stub
		user data=this.userrepo.findById(id).orElse(null);
		if(data==null) {
			return null;
		}
		
		if(user.getEmail()!=null) {
			data.setEmail(user.getEmail());
		}
		if(user.getName()!=null) {
			data.setName(user.getName());
		}
		if(user.getPasswordHash()!=null) {
			data.setPasswordHash(user.getPasswordHash());
		}
		if(user.getPhone()!=null) {
			data.setPhone(user.getPhone());
		}
		if(user.getRole()!=null) {
			data.setRole(user.getRole());
		}
		return this.userrepo.save(data);
	}

	@Override
	public user Delete_single_user(Long id) {
		// TODO Auto-generated method stub
		try {
			user  u=Read_single_user(id);
			this.userrepo.delete(u);
			return u;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean Delete_all_user() {
		// TODO Auto-generated method stub
		try {
			this.userrepo.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return  false;
	}

	@Override
	public user Read_by_username(String email) {
		// TODO Auto-generated method stub
		return this.userrepo.findByEmail(email).orElse(null);
	}
	
	

}
