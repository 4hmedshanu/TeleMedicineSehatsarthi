package com.telemedicine.allservices_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.Doctor;
import com.telemedicine.allentity.allocatepatient;
import com.telemedicine.allentity.patient;
import com.telemedicine.allrepository.alloccatepatient_repo;
import com.telemedicine.allrepository.doctor_repo;
import com.telemedicine.allrepository.patient_repo;
import com.telemedicine.allservicesprovider.alocationpatient;

@Service
public class allocatepatient_imple implements alocationpatient {
	
	@Autowired
	alloccatepatient_repo repo;
	
	@Autowired 
	doctor_repo doc_repo;
	
	@Autowired
	patient_repo patient_repo;

	@Override
	public allocatepatient createdAllocatepatient(allocatepatient all, Long patient_id, Long doctor_id) {
		// TODO Auto-generated method stu
		
		  Doctor doc = doc_repo.findById(doctor_id).orElse(null);
	        patient p = patient_repo.findByPatientId(patient_id).orElse(null);

	        if (doc == null && p == null) {
	            throw new RuntimeException("Doctor or Patient not found!");
	        }

	        all.setDoctor(doc);
	        all.setPatient(p);
	        all.setFlag(true);
		return this.repo.save(all);
	}

	@Override
	public List<allocatepatient> getallocatepatient() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public List<allocatepatient> getallocatepatientbydr(Long id) {
		// TODO Auto-generated method stub
		Doctor dr=this.doc_repo.findByDoctorId(id).orElse(null);
		if(dr==null) {
			return null;
		}
		List<allocatepatient> patien=this.repo.findByDoctor(dr);
		return patien;
	}
	
	public allocatepatient getallbypatient(Long id) {
		 patient patie= patient_repo.findByPatientId(id).orElse(null);
		 if(patie==null) {
			 return null;
		 }
		 allocatepatient p=this.repo.findByPatient(patie).orElse(null);
		 if(p==null) {
			 return null;
		 }
		 return p;
	}
	
	public boolean deleteall() {
		this.repo.deleteAll();
		return true;
	}
	
	
	

}
