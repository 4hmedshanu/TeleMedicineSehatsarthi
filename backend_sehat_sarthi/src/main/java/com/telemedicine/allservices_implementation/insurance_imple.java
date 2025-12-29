package com.telemedicine.allservices_implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telemedicine.allentity.insurance;
import com.telemedicine.allrepository.insurance_repo;
import com.telemedicine.allservicesprovider.insurance_interface;

@Service
public class insurance_imple implements insurance_interface {
	
	@Autowired 
	insurance_repo insurance_repo;

	@Override
	public insurance Create_insurance(insurance insurance) {
		// TODO Auto-generated method stub
		return this.insurance_repo.save(insurance);
	}

	@Override
	public List<insurance> Read_all_insurance() {
		// TODO Auto-generated method stub
		return this.insurance_repo.findAll();
	}

	@Override
	public insurance Read_single_insurance(Long id) {
		// TODO Auto-generated method stub
		return this.insurance_repo.findById(id).get();
	}

	@Override
	public insurance update_insurance(insurance insurance, Long id) {
		// TODO Auto-generated method stub
		 insurance in_rep=this.insurance_repo.findById(id).orElse(null);
		 if(in_rep!=null) {
			if(insurance.getPolicyNumber()!=null) {
				in_rep.setPolicyNumber(insurance.getPolicyNumber());
			}
			if(insurance.getProviderName()!=null) {
				in_rep.setProviderName(insurance.getProviderName());
			}
			if(insurance.getValidTill()!=null) {
				in_rep.setValidTill(insurance.getValidTill());
			}
			if(insurance.getCoverageDetails()!=null) {
				in_rep.setCoverageDetails(insurance.getCoverageDetails());
			}
			return this.insurance_repo.save(in_rep);
		 }
		
		return null;
	}

	@Override
	public insurance Delete_single_insurance(Long id) {
		// TODO Auto-generated method stub
		try {
			 insurance in=this.insurance_repo.findById(id).get();
			 this.insurance_repo.delete(in);
			return in;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return null;
	}
	

	@Override
	public boolean Delete_all_insurance() {
		// TODO Auto-generated method stub
		try {
			this.insurance_repo.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		return false;
	}
	

}
