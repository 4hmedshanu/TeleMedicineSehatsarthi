package com.telemedicine.allentity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class patient {
    @Id
    private Long patientId; // also FK to User

    private String dob;
    private String gender;
    private String address;
    private String bloodGroup;
    private String emergencyContact;
    
    
    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private insurance insurance;
    
    // Each patient is linked to exactly one user
    @OneToOne
    @MapsId
    @JoinColumn(name = "patient_id")
    private user user;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(insurance insurance) {
		this.insurance = insurance;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}
	
	

	public patient(Long patientId, String dob, String gender, String address, String bloodGroup,
			String emergencyContact, com.telemedicine.allentity.insurance insurance,
			com.telemedicine.allentity.user user) {
		super();
		this.patientId = patientId;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.emergencyContact = emergencyContact;
		this.insurance = insurance;
		this.user = user;
	}

	public patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
    
    

}
