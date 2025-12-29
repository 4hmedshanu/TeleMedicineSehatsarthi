package com.telemedicine.allentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class hospital {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long hospitalId;

	    private String name;
	    private String address;
	    private String contactInfo;
	    
		public Long getHospitalId() {
			return hospitalId;
		}
		public void setHospitalId(Long hospitalId) {
			this.hospitalId = hospitalId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getContactInfo() {
			return contactInfo;
		}
		public void setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
		}
		public hospital(Long hospitalId, String name, String address, String contactInfo) {
			super();
			this.hospitalId = hospitalId;
			this.name = name;
			this.address = address;
			this.contactInfo = contactInfo;
		}
		public hospital() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
		
		
	    
	    
}
