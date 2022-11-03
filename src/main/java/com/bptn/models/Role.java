package com.bptn.models;

import javax.persistence.*;


@Entity 
@Table (name = "\"Role\"")


public class Role {
	
	@Id
	@Column ( name = "\"usernameKey\"")
	String usernameKey;
	
	@Column ( name = "\"roleName\"")
	String roleName;
	
	@Column ( name = "company")
	String company;
	
	@Column ( name = "skills")
	String skills;
	
	public Role() {
		super();
	}
	
	public Role(String usernameKey, String roleName, String company, String skills) {
		super();
		this.usernameKey = usernameKey;
		this.roleName = roleName;
		this.company = company;
		this.skills = skills;
	}


	public String getUsernameKey() {
		return usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	
	@Override
	public String toString() {
		return "Role [usernameKey=" + usernameKey + ", roleName=" + roleName + ", company=" + company + ", skills="
				+ skills + "]";
	}
	
	

	



}
