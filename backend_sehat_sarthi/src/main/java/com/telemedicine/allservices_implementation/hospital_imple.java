package com.telemedicine.allservices_implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.hospital;
import com.telemedicine.allrepository.hospital_repo;
import com.telemedicine.allservicesprovider.hospital_interface;

@Service
public class hospital_imple implements hospital_interface{
	
	@Autowired
	hospital_repo hospital_repo;

	@Override
	public hospital Createhospital(hospital hospital) {
		// TODO Auto-generated method stub
		return  this.hospital_repo.save(hospital);
	}

	@Override
	public List<hospital> Read_all_hospital() {
		// TODO Auto-generated method stub
		return this.hospital_repo.findAll();
	}

	@Override
	public hospital Read_single_hospital(Long id) {
		// TODO Auto-generated method stub
		return this.hospital_repo.findById(id).get();
	}

	@Override
	public hospital update_hospital(hospital hosp, Long id) {
		// TODO Auto-generated method stub
		    hospital ho=this.hospital_repo.findById(id).get();
		    
		    if(hosp.getName()!=null) {
		    	 ho.setName(hosp.getName());
		    }
		    if(hosp.getContactInfo()!=null) {
		    	 ho.setContactInfo(hosp.getContactInfo());
		    }
		    if(hosp.getAddress()!=null) {
		    	ho.setAddress(hosp.getAddress());
		    }
		    
		return this.hospital_repo.save(ho);
	}

	@Override
	public hospital Delete_single_hospital(Long id) {
		// TODO Auto-generated method stub
		try {
			hospital ho=this.hospital_repo.findById(id).orElse(null);
			this.hospital_repo.delete(ho);
			return ho;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean Delete_all_hospital() {
		// TODO Auto-generated method stub
		try {
			this.hospital_repo.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return false;
	}
	

	@Override
	public hospital Read_by_username(String name) {
		// TODO Auto-generated method stub
		return this.hospital_repo.findByName(name).orElse(null);
	}
	

}
