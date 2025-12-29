package com.telemedicine.allservices_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.Doctor;
import com.telemedicine.allentity.patient;
import com.telemedicine.allentity.prescriptions;
import com.telemedicine.allrepository.doctor_repo;
import com.telemedicine.allrepository.patient_repo;
import com.telemedicine.allrepository.prescriptions_repo;
import com.telemedicine.allservicesprovider.prescriptions_interface;


@Service
public class prescriptions_imple implements prescriptions_interface {
	
	@Autowired
	prescriptions_repo prescriptions_repo;
	
	@Autowired
	patient_repo patient_rep;
	
	@Autowired
	doctor_repo doctor_repo;


	@Override
	public prescriptions Create_prescriptions(prescriptions prescriptions, Long patient_id, Long doctor_id) {
		// TODO Auto-generated method stub
		 Doctor d=this.doctor_repo.findByDoctorId(doctor_id).orElse(null);
		 patient  p=this.patient_rep.findByPatientId(patient_id).orElse(null);
		 
		
		if(d!=null && p!=null) {
			prescriptions.setDoctor(d);
			prescriptions.setPatient(p);
			return this.prescriptions_repo.save(prescriptions);
		}
		
		return null;
	}
	

	@Override
	public List<prescriptions> Read_all_prescriptions() {
		// TODO Auto-generated method stub
		return this.prescriptions_repo.findAll();
	}
	
	

	@Override
	public prescriptions Read_single_prescriptions(Long id) {
		// TODO Auto-generated method stub
		return this.prescriptions_repo.findById(id).get();
	}
	

	@Override
	public prescriptions update_prescriptions(prescriptions prescipt, Long id) {
		// TODO Auto-generated method stub
		 prescriptions pre=this.prescriptions_repo.findById(id).orElse(null);
		 if(pre!=null) {
			 
			 if(prescipt.getMedicationName()!=null) {
				 pre.setMedicationName(prescipt.getMedicationName());
			 }
			 if(prescipt.getDosage()!=null) {
				 pre.setDosage(prescipt.getDosage());
			 }
			 if(prescipt.getDuration()!=null) {
				 pre.setDuration(prescipt.getDuration());
			 }
			 if(prescipt.getFrequency()!=null) {
				 pre.setFrequency(prescipt.getFrequency());
			 }
			 if(prescipt.getInstructions()!=null) {
				 pre.setInstructions(prescipt.getInstructions());
			 }
			 
			 return this.prescriptions_repo.save(pre);
 
		 }
		 
		return null;
	}

	@Override
	public prescriptions Delete_single_prescriptions(Long id) {
		// TODO Auto-generated method stub
		try {
			prescriptions p=this.prescriptions_repo.findById(id).orElse(null);
			if(p!=null) {
				this.prescriptions_repo.delete(p);
				return p;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean Delete_all_prescriptions() {
		// TODO Auto-generated method stub
		try {
			this.prescriptions_repo.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
	

}
