package com.telemedicine.entity;

public class appointments {
	
	 private Long appointmentId;
	 private patient patient;
	 private Doctor doctor;

	   
	    private hospital hospital;

	    private String appointmentDate;
	    private String appointmentTime;
	    private String status;
	    private String consultationType;
		public Long getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(Long appointmentId) {
			this.appointmentId = appointmentId;
		}
		public patient getPatient() {
			return patient;
		}
		public void setPatient(patient patient) {
			this.patient = patient;
		}
		public Doctor getDoctor() {
			return doctor;
		}
		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}
		public hospital getHospital() {
			return hospital;
		}
		public void setHospital(hospital hospital) {
			this.hospital = hospital;
		}
		public String getAppointmentDate() {
			return appointmentDate;
		}
		public void setAppointmentDate(String appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
		public String getAppointmentTime() {
			return appointmentTime;
		}
		public void setAppointmentTime(String appointmentTime) {
			this.appointmentTime = appointmentTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getConsultationType() {
			return consultationType;
		}
		public void setConsultationType(String consultationType) {
			this.consultationType = consultationType;
		}
		@Override
		public String toString() {
			return "appointments [appointmentId=" + appointmentId + ", patient=" + patient + ", doctor=" + doctor
					+ ", hospital=" + hospital + ", appointmentDate=" + appointmentDate + ", appointmentTime="
					+ appointmentTime + ", status=" + status + ", consultationType=" + consultationType + "]";
		}
		
		
		
		
		
		
		
	    
	    
	    

}
