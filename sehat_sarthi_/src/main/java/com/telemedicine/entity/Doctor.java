package com.telemedicine.entity;



public class Doctor {
	
	 	private Long doctorId; // also FK to User
	    private String specialization;
	    private String qualification;
	    private int experienceYears;
	    private String licenseNumber;
	    private String clinicAddress;
	    private String availabilityStatus;
	    private user user;
		public Long getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(Long doctorId) {
			this.doctorId = doctorId;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}
		public String getQualification() {
			return qualification;
		}
		public void setQualification(String qualification) {
			this.qualification = qualification;
		}
		public int getExperienceYears() {
			return experienceYears;
		}
		public void setExperienceYears(int experienceYears) {
			this.experienceYears = experienceYears;
		}
		public String getLicenseNumber() {
			return licenseNumber;
		}
		public void setLicenseNumber(String licenseNumber) {
			this.licenseNumber = licenseNumber;
		}
		public String getClinicAddress() {
			return clinicAddress;
		}
		public void setClinicAddress(String clinicAddress) {
			this.clinicAddress = clinicAddress;
		}
		public String getAvailabilityStatus() {
			return availabilityStatus;
		}
		public void setAvailabilityStatus(String availabilityStatus) {
			this.availabilityStatus = availabilityStatus;
		}
		public user getUser() {
			return user;
		}
		public void setUser(user user) {
			this.user = user;
		}
		public Doctor(Long doctorId, String specialization, String qualification, int experienceYears,
				String licenseNumber, String clinicAddress, String availabilityStatus,
				com.telemedicine.entity.user user) {
			super();
			this.doctorId = doctorId;
			this.specialization = specialization;
			this.qualification = qualification;
			this.experienceYears = experienceYears;
			this.licenseNumber = licenseNumber;
			this.clinicAddress = clinicAddress;
			this.availabilityStatus = availabilityStatus;
			this.user = user;
		}
		public Doctor() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Doctor [doctorId=" + doctorId + ", specialization=" + specialization + ", qualification="
					+ qualification + ", experienceYears=" + experienceYears + ", licenseNumber=" + licenseNumber
					+ ", clinicAddress=" + clinicAddress + ", availabilityStatus=" + availabilityStatus + ", user="
					+ user + "]";
		}
		
		
	    
	    

}
