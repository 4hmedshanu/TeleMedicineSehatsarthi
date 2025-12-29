package com.telemedicine.allentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance")
public class insurance {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long insuranceId;

	    private String providerName;
	    private String policyNumber;
	    private String coverageDetails;
	    private String validTill;
		public Long getInsuranceId() {
			return insuranceId;
		}
		public void setInsuranceId(Long insuranceId) {
			this.insuranceId = insuranceId;
		}
		public String getProviderName() {
			return providerName;
		}
		public void setProviderName(String providerName) {
			this.providerName = providerName;
		}
		public String getPolicyNumber() {
			return policyNumber;
		}
		public void setPolicyNumber(String policyNumber) {
			this.policyNumber = policyNumber;
		}
		public String getCoverageDetails() {
			return coverageDetails;
		}
		public void setCoverageDetails(String coverageDetails) {
			this.coverageDetails = coverageDetails;
		}
		public String getValidTill() {
			return validTill;
		}
		public void setValidTill(String validTill) {
			this.validTill = validTill;
		}
		public insurance(Long insuranceId, String providerName, String policyNumber, String coverageDetails,
				String validTill) {
			super();
			this.insuranceId = insuranceId;
			this.providerName = providerName;
			this.policyNumber = policyNumber;
			this.coverageDetails = coverageDetails;
			this.validTill = validTill;
		}
		public insurance() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    

}
