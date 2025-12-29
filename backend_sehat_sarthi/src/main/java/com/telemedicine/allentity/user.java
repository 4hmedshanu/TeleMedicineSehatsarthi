package com.telemedicine.allentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class user {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userId;
	    private String name;
	    @Column( unique = true, nullable = false)
	    private String email;
	    private String passwordHash;
	    private Long phone;
	    private String role;
	    
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPasswordHash() {
			return passwordHash;
		}
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
				
	
		public Long getPhone() {
			return phone;
		}
		public void setPhone(Long phone) {
			this.phone = phone;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public user(Long userId, String name, String email, String passwordHash, Long phone, String role) {
			super();
			this.userId = userId;
			this.name = name;
			this.email = email;
			this.passwordHash = passwordHash;
			this.phone = phone;
			this.role = role;
		}
		public user() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
	
}
