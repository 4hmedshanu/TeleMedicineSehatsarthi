package com.telemedicine.allentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class admin {
	   @Id
	    private Long adminId; // also FK to User

	    private String roleType;
	    private String permissions;

	    @OneToOne
	    @MapsId
	    @JoinColumn(name = "admin_id")
	    private user user;

		public Long getAdminId() {
			return adminId;
		}

		public void setAdminId(Long adminId) {
			this.adminId = adminId;
		}

		public String getRoleType() {
			return roleType;
		}

		public void setRoleType(String roleType) {
			this.roleType = roleType;
		}

		public String getPermissions() {
			return permissions;
		}

		public void setPermissions(String permissions) {
			this.permissions = permissions;
		}

		public user getUser() {
			return user;
		}

		public void setUser(user user) {
			this.user = user;
		}

		public admin(Long adminId, String roleType, String permissions, com.telemedicine.allentity.user user) {
			super();
			this.adminId = adminId;
			this.roleType = roleType;
			this.permissions = permissions;
			this.user = user;
		}

		public admin() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	    
		
		
	    
	    
	    
}
