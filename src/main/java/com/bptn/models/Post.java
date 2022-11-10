package com.bptn.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@OneToOne(mappedBy = "post")
	ImageMetaData imageMetaData;   
	
	public Post() {
		super();
	}
	
	public Post (String postID) {
		super();
		this.postID = postID; 
	}
	
	public Post(String postID, String postType, UserID userID, ImageMetaData imageMetaData) {
		super();
		this.postID = postID;
		this.postType = postType;
		this.userID = userID;
		this.imageMetaData = imageMetaData;
	}

	public UserID getUserID() {
		return userID;
	}

	public void setUserID(UserID userID) {
		this.userID = userID;
	}
	
	public ImageMetaData getImageMetaData() {
		return imageMetaData;
	}

	public void setImageMetaData(ImageMetaData imageMetaData) {
		this.imageMetaData = imageMetaData;
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

	@Override
	public String toString() {
		return "Post [postID=" + postID + ", postType=" + postType + ", userID=" + userID + ", imageMetaData="
				+ imageMetaData + "]";
	}
	
	
}