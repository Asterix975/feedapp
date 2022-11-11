package com.bptn.models;


import javax.persistence.Entity; 
import javax.persistence.Table; 
import javax.persistence.Column;

import java.util.List;

import javax.persistence.*;


@Entity 
@Table (name = "\"userID\"")

public class UserID {
	
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
	
	@OneToMany(mappedBy="userID") // userID is the object name we use in the post entity
	List<Post>posts; 
	
	@OneToMany(mappedBy="userID") // userID is the object name we use in the post entity
	List<History>history; 


	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public UserID (String username) {
		super();
		this.username = username; 
	}
	
	public UserID () {
		super();
	}

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
	

	public List<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	@Override
	public String toString() {
		return "UserID [username=" + username + ", name=" + name + ", emailID=" + emailID + ", phoneNumber="
				+ phoneNumber + ", userPassword=" + userPassword + ", posts=" + posts + ", history=" + history + "]";
	}
}


	
	
