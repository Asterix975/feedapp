package com.bptn.models;


import javax.persistence.*;


@Entity 
@Table (name = "\"Profile\"")


public class Profile {

	
	@Id
	@Column ( name = "\"usernameKey\"")
	String usernameKey;
	
	@Column ( name = "position")
	String position;
	
	@Column ( name = "company")
	String company;
	
	@Column ( name = "\"companyAddress\"")
	String companyAddress;
	
	@Column ( name = "interests")
	String interests;
	
	@Column ( name = "experience")
	String experience;
	
	@Column ( name = "education")
	String education;
	
	@Column ( name = "certification")
	String certification;
	
	@Column ( name = "skills")
	String skills;
	
	@Column ( name = "language")
	String language;
	
	public Profile() {
		super();
	}
	
	public Profile(String usernameKey, String position, String company, String companyAddress, String interests,
			String experience, String education, String certification, String skills, String language) {
		super();
		this.usernameKey = usernameKey;
		this.position = position;
		this.company = company;
		this.companyAddress = companyAddress;
		this.interests = interests;
		this.experience = experience;
		this.education = education;
		this.certification = certification;
		this.skills = skills;
		this.language = language;
	}


	public String getUsernameKey() {
		return usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	@Override
	public String toString() {
		return "Profile [usernameKey=" + usernameKey + ", position=" + position + ", company=" + company
				+ ", companyAddress=" + companyAddress + ", interests=" + interests + ", experience=" + experience
				+ ", education=" + education + ", certification=" + certification + ", skills=" + skills + ", language="
				+ language + "]";
	}
	
	
	
	
	
	
	
}
