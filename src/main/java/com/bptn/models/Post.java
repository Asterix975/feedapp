package com.bptn.models;



import javax.persistence.Entity; 
import javax.persistence.Table; 
import javax.persistence.Column;
import javax.persistence.*;


@Entity 
@Table (name = "\"Post\"")

public class Post{
	
	@Id
	@Column ( name = "\"postID\"")
	String postID;
	
	@Column ( name = "\"postType\"")
	String postType;
	
	@Column ( name = "\"usernameKey\"")
	String usernameKey;

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

	public String getUsernameKey() {
		return usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

	public Post(String postID, String postType, String usernameKey) {
		super();
		this.postID = postID;
		this.postType = postType;
		this.usernameKey = usernameKey;
	}

	@Override
	public String toString() {
		return "Post [postID=" + postID + ", postType=" + postType + ", usernameKey=" + usernameKey + "]";
	} 
	
	
	
	
}