package com.bptn.models;


import javax.persistence.*;


@Entity 
@Table (name = "\"History\"")


public class History {
	
	@Id
	@Column ( name = "\"postID\"")
	String postID;
	
	@Column ( name = "date")
	String date;
	
	@Column ( name = "\"postType\"")
	String postType;
	
	@Column ( name = "\"postUpload\"")
	String postUpload;
	
	@Column ( name = "\"usernamekey\"")
	String usernameKey;

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

	public String getUsernameKey() {
		return usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

	public History(String postID, String date, String postType, String postUpload, String usernameKey) {
		super();
		this.postID = postID;
		this.date = date;
		this.postType = postType;
		this.postUpload = postUpload;
		this.usernameKey = usernameKey;
	}

	@Override
	public String toString() {
		return "History [postID=" + postID + ", date=" + date + ", postType=" + postType + ", postUpload=" + postUpload
				+ ", usernameKey=" + usernameKey + "]";
	}
	
	



}
