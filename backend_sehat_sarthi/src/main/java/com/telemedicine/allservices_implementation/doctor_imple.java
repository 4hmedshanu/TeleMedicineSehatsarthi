package com.telemedicine.allservices_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.Doctor;
import com.telemedicine.allentity.user;
import com.telemedicine.allrepository.doctor_repo;
import com.telemedicine.allrepository.user_repo;
import com.telemedicine.allservicesprovider.doctor_interface;

@Service
public class doctor_imple implements doctor_interface{
	
	@Autowired
	doctor_repo doctor_repo;
	
	@Autowired
	user_repo user_repo;

	@Override
	public Doctor Create_doctor(Doctor doctor, Long id) {
		// TODO Auto-generated method stub
		user u=user_repo.findById(id).orElse(null);
		if(u!=null) {
			doctor.setUser(u);
			return this.doctor_repo.save(doctor);
		}
		return null;
	}

	@Override
	public List<Doctor> Read_all_doctor() {
		// TODO Auto-generated method stub
		return  this.doctor_repo.findAll();
	}

	@Override
	public Doctor Read_single_doctor(Long id) {
		// TODO Auto-generated method stub
		return this.doctor_repo.findByDoctorId(id).orElse(null);
	}

	@Override
	public Doctor update_doctor(Doctor doctor, Long id) {
		// TODO Auto-generated method stub
		 Doctor dr =this.doctor_repo.findByDoctorId(id).orElse(null);
		 if(dr!=null) {
			 if(doctor.getAvailabilityStatus()!=null) {
				 dr.setAvailabilityStatus(doctor.getAvailabilityStatus());
			 }
			 if(doctor.getClinicAddress()!=null) {
				 dr.setClinicAddress(doctor.getClinicAddress());
			 }
			 if(doctor.getExperienceYears()>=0) {
				 dr.setExperienceYears(0);
			 }
			 if(doctor.getLicenseNumber()!=null) {
				 dr.setLicenseNumber(doctor.getLicenseNumber());
			 }
			 if(doctor.getQualification()!=null) {
				 dr.setQualification(doctor.getQualification());
			 }
			 if(doctor.getSpecialization()!=null) {
				 dr.setSpecialization(doctor.getSpecialization());
			 }
			 return this.doctor_repo.save(dr);
		 }
		
		return null;
	}

	@Override
	public Doctor Delete_single_doctor(Long id) {
		// TODO Auto-generated method stub
		try {
			Doctor dr=this.doctor_repo.findByDoctorId(id).orElse(null);
			if(dr!=null) {
				this.doctor_repo.delete(dr);
				return dr;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	

	@Override
	public boolean Delete_all_doctor() {
		// TODO Auto-generated method stub
		try {
			this.doctor_repo.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		
		return false;
	}
	
	public Doctor getdoctorbyuser(String email) {
		user u=this.user_repo.findByEmail(email).orElse(null);
		if(u==null) {
			return null;
		}
		Doctor doc=this.doctor_repo.findByUser(u).orElse(null);
		if(doc==null) {
			return null;
		}
		return doc;
	}
	
	

}
