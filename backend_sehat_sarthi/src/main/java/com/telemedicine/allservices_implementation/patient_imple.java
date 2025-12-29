package com.telemedicine.allservices_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.patient;
import com.telemedicine.allentity.user;
import com.telemedicine.allrepository.patient_repo;
import com.telemedicine.allrepository.user_repo;
import com.telemedicine.allservicesprovider.patient_interface;

@Service
public class patient_imple implements patient_interface {
	
	@Autowired
	patient_repo patientrepo;
	
	@Autowired
	user_repo user_repo;

	@Override
	public patient Create_patient(patient patient ,Long id) {
		// TODO Auto-generated method stub
		user u=user_repo.findById(id).orElse(null);
		if(u!=null) {
			patient.setUser(u);
			return this.patientrepo.save(patient);
		}
		
		return null;
	}

	@Override
	public List<patient> Read_all_patient() {
		// TODO Auto-generated method stub
		return this.patientrepo.findAll();
	}

	@Override
	public patient Read_single_patient(Long id) {
		// TODO Auto-generated method stub
		return this.patientrepo.findByPatientId(id).orElse(null);
	}

	@Override
	public patient update_patient(patient patient, Long id) {
		// TODO Auto-generated method stub
		patient data =this.patientrepo.findByPatientId(id).orElse(null);
		if(data!=null) {
			
			if(patient.getBloodGroup()!=null) {
				data.setBloodGroup(patient.getBloodGroup());
			}
			if(patient.getAddress()!=null) {
				data.setAddress(patient.getAddress());
			}
			if(patient.getDob()!=null) {
				data.setDob(patient.getDob());
			}
			if(patient.getGender()!=null) {	
				data.setGender(patient.getGender());
			}
			if(patient.getEmergencyContact()!=null) {	
				data.setEmergencyContact(patient.getEmergencyContact());
			}
			return this.patientrepo.save(data);
		}
		return null;
	}

	@Override
	public patient Delete_single_patient(Long id) {
		// TODO Auto-generated method stub
		try {
			  patient  p=this.patientrepo.findByPatientId(id).get();
			  this.patientrepo.delete(p);
			  return p;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean Delete_all_patient() {
		// TODO Auto-generated method stub
		try {
			this.patientrepo.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
	public patient getsinglebyuser(String email) {
		user user=this.user_repo.findByEmail(email).orElse(null);
		if(user==null) {
			return null;
		}
		patient patient=this.patientrepo.findByUser(user).orElse(null);
		if(patient==null) {
			return null;
		}
		
		return patient;
		
	}
	

}
