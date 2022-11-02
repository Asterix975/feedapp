package com.bptn.models;


import javax.persistence.Entity; 
import javax.persistence.Table; 
import javax.persistence.Column;
import javax.persistence.*;


@Entity 
@Table (name = "\"userID\"")

public class userID {
	
	@Id
	@Column ( name = "username")
	String username;
	
	@Column ( name = "name")
	String name;
	
	@Column ( name = "\"emailID\"")
	String emailID;
	
	@Column ( name = "\"phoneNumber\"")
	String phoneNumber;
	
	@Column ( name = "\"userPassword\"")
	String userPassword;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public userID(String username, String name, String emailID, String phoneNumber, String userPassword) {
		super();
		this.username = username;
		this.name = name;
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "userID [username=" + username + ", name=" + name + ", emailID=" + emailID + ", phoneNumber="
				+ phoneNumber + ", userPassword=" + userPassword + "]";
	} 
	


}
