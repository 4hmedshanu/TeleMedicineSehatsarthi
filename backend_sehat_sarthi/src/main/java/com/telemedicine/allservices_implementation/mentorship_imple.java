package com.telemedicine.allservices_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.Doctor;
import com.telemedicine.allentity.mentorship;
import com.telemedicine.allentity.patient;
import com.telemedicine.allrepository.doctor_repo;
import com.telemedicine.allrepository.mentorship_repo;
import com.telemedicine.allrepository.patient_repo;
import com.telemedicine.allservicesprovider.mentorship_interface;

@Service
public class mentorship_imple  implements mentorship_interface{
	
	@Autowired
	mentorship_repo mentorship_repo;
	
	@Autowired
	patient_repo patient_rep;
	
	@Autowired
	doctor_repo doctor_repo;
	

	@Override
	public mentorship Create_mentorship(mentorship mentorship, Long pation_id, Long doctor_id) {
		// TODO Auto-generated method stub
		 Doctor d=this.doctor_repo.findByDoctorId(doctor_id).orElse(null);
		 patient  p=this.patient_rep.findByPatientId(pation_id).orElse(null);
		
		if(d!=null && p!=null) {
			mentorship.setDoctor(d);
			mentorship.setPatient(p);
			return mentorship_repo.save(mentorship);
		}
		return null;
	}

	@Override
	public List<mentorship> Read_all_mentorship() {
		// TODO Auto-generated method stub
		return this.mentorship_repo.findAll();
	}

	@Override
	public mentorship Read_single_mentorship(Long id) {
		// TODO Auto-generated method stub
		return this.mentorship_repo.findById(id).get();
	}

	@Override
	public mentorship update_mentorship(mentorship mentorship, Long id) {
		// TODO Auto-generated method stub
		 mentorship ment=this.mentorship_repo.findById(id).orElse(null);
		 
		 if(ment!=null) {
			 if(mentorship.getMentorshipDate()!=null) {
				 ment.setMentorshipDate(mentorship.getMentorshipDate());
			 }
			 if(mentorship.getNotes()!=null) {
				 ment.setNotes(mentorship.getNotes());
			 }
			 
			 return this.mentorship_repo.save(ment);
		 }
		 
		return null;
	}

	@Override
	public mentorship Delete_single_mentoship(Long id) {
		// TODO Auto-generated method stub
		try {
			  mentorship  ment=this.mentorship_repo.findById(id).get();
			  this.mentorship_repo.delete(ment);
			return ment;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean Delete_all_mentoship() {
		// TODO Auto-generated method stub
		try {
			
			this.mentorship_repo.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return false;
	}
	
	
	
	
	

}
