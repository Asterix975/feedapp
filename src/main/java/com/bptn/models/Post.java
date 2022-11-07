package com.bptn.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity 
@Table (name = "\"Post\"")

public class Post{
	
	@Id
	@Column ( name = "\"postID\"")
	String postID;
	
	@Column ( name = "\"postType\"")
	String postType;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="\"usernameKey\"")
	UserID userID;   //relation with the userid table 
	
	
	public void setUserID(UserID userID) {
		this.userID = userID;
	}

	public Post() {
		super();
	}
	
	public Post(String postID, String postType, UserID userID) {
		super();
		this.postID = postID;
		this.postType = postType;
		this.userID = userID;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public UserID getUserID() {
		return this.userID ;
	}

	public void setUsernameKey(UserID userID) {
		this.userID= userID;
	}

	

	@Override
	public String toString() {
		return "Post [postID=" + postID + ", postType=" + postType + ", userID=" + userID + "]";
	} 
	
	
	
	
}