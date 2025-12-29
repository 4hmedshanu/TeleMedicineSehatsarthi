package com.telemedicine.entity;



public class patient {
	
	 private Long patientId; // also FK to User

	    private String dob;
	    private String gender;
	    private String address;
	    private String bloodGroup;
	    private String emergencyContact;
	    private user user;
//	    private insurance insurance;
		public Long getPatientId() {
			return patientId;
		}
		public void setPatientId(Long patientId) {
			this.patientId = patientId;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		public String getEmergencyContact() {
			return emergencyContact;
		}
		public void setEmergencyContact(String emergencyContact) {
			this.emergencyContact = emergencyContact;
		}
		public user getUser() {
			return user;
		}
		public void setUser(user user) {
			this.user = user;
		}
		public patient(Long patientId, String dob, String gender, String address, String bloodGroup,
				String emergencyContact, com.telemedicine.entity.user user) {
			super();
			this.patientId = patientId;
			this.dob = dob;
			this.gender = gender;
			this.address = address;
			this.bloodGroup = bloodGroup;
			this.emergencyContact = emergencyContact;
			this.user = user;
		}
		public patient() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "patient [patientId=" + patientId + ", dob=" + dob + ", gender=" + gender + ", address=" + address
					+ ", bloodGroup=" + bloodGroup + ", emergencyContact=" + emergencyContact + ", user=" + user + "]";
		}
		
		
	    
	    
	    
	    

}
