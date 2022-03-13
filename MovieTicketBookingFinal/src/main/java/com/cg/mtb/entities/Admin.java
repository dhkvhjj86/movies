package com.cg.mtb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private int adminId;
	private String adminContact;
	private String adminName;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Admin(int adminId, String adminContact, String adminName) {
		super();
		this.adminId = adminId;
		this.adminContact = adminContact;
		this.adminName = adminName;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminContact=" + adminContact + ", adminName=" + adminName + "]";
	}
	
	
	
	public Admin() {}

}
