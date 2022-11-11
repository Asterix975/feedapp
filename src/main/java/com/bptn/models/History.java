package com.bptn.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="\"History\"")
public class History {

	@Id
	@Column(name="\"postID\"")
	String postID;

	@Column(name="date")
	String date;

	@Column(name="\"postType\"")
	String postType;

	@Column(name="\"postUpload\"")
	String postUpload;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="\"usernameKey\"")
	UserID userID;   

	public UserID getUserID() {
		return userID;
	}

	public void setUserID(UserID userID) {
		this.userID = userID;
	}

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostUpload() {
		return postUpload;
	}

	public void setPostUpload(String postUpload) {
		this.postUpload = postUpload;
	}

	@Override
	public String toString() {
		return "History [postID=" + postID + ", date=" + date + ", postType=" + postType + ", postUpload=" + postUpload
				+ ", userID=" + userID + "]";
	}




}