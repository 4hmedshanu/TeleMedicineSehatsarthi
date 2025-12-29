package com.telemedicine.allservices_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.Doctor;
import com.telemedicine.allentity.appointments;
import com.telemedicine.allentity.patient;
import com.telemedicine.allrepository.appointment_repo;
import com.telemedicine.allservicesprovider.appointment_interface;

import com.telemedicine.allrepository.*;

@Service
public class appointment_imple implements appointment_interface {
	
	@Autowired
	appointment_repo appo_repo;
	@Autowired
	doctor_repo doctor_repo;
	
	@Autowired
	patient_repo patient_repo;
	
	


	@Override
	public List<appointments> get_allappoinments() {
		// TODO Auto-generated method stub
		return this.appo_repo.findAll();
	}
	

	@Override
	public appointments get_single_appoinments(Long id) {
		// TODO Auto-generated method stub
		return this.appo_repo.findById(id).orElse(null);
	}
	

	@Override
	public appointments update_appoinments(appointments appoinments, Long id) {
		// TODO Auto-generated method stub
		appointments ap=this.appo_repo.findById(id).orElse(null);
		
		if(ap!=null) {
			if(appoinments.getAppointmentDate()!=null) {
				ap.setAppointmentDate(appoinments.getAppointmentDate());
			}
			if(appoinments.getAppointmentTime()!=null) {
				ap.setAppointmentTime(appoinments.getAppointmentTime());
			}
			if(appoinments.getConsultationType()!=null) {
				ap.setConsultationType(appoinments.getConsultationType());
			}
			if(appoinments.getStatus()!=null) {
				ap.setStatus(appoinments.getStatus());
			}
			
			return this.appo_repo.save(ap);
		}
		return null;
	}
	

	@Override
	public appointments Delete_single_appoinments(Long id) {
		// TODO Auto-generated method stub
		try {
			 appointments ap=this.appo_repo.findById(id).orElse(null);
			 if(ap!=null) {
				 this.appo_repo.delete(ap);
				 return ap;
			 }
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean Delete_all_appoinments() {
		// TODO Auto-generated method stub
		this.appo_repo.deleteAll();
		return false;
	}


	@Override
	public appointments book_appoinments(appointments appoin, Long pationsid, Long Doctorid) {
		// TODO Auto-generated method stubbackendSehatSarthiApplication
		
		Doctor doctor=this.doctor_repo.findByDoctorId(Doctorid).orElse(null);
		patient patient=this.patient_repo.findByPatientId(pationsid).orElse(null);
		if(patient!=null && doctor!=null) {
			
			appoin.setDoctor(doctor);
			appoin.setPatient(patient);
			
			return this.appo_repo.save(appoin);
		}
		
		return null;
	}
	
	
	public List<appointments> getAppointmentsbypation(Long patientid) {
		 patient patient=this.patient_repo.findByPatientId(patientid).orElse(null);
		 if(patient==null) {
			 return null;
		 }
		 List<appointments> all=this.appo_repo.findByPatient(patient);
		return all;
		
	}
	
	


	
	

}
