package com.bptn.models;

import javax.persistence.*;

@Entity 
@Table (name = "\"ImageMetaData\"")


public class ImageMetaData {
	
	
	@Id
	@Column ( name = "\"imageID\"")
	String imageID;
	
	@Column ( name = "\"imageName\"")
	String imageName;
	
	@Column ( name = "\"imageSize\"")
	String imageSize;
	
	@Column ( name = "\"imageFormat\"")
	String imageFormat;
	
	@Column ( name = "\"imageDate\"")
	String imageDate;
	
	@Column ( name = "resolution")
	String resolution;

	@Column ( name = "\"postKey\"")
	String postKey;

	public String getImageID() {
		return imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageSize() {
		return imageSize;
	}

	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}

	public String getImageFormat() {
		return imageFormat;
	}

	public void setImageFormat(String imageFormat) {
		this.imageFormat = imageFormat;
	}

	public String getImageDate() {
		return imageDate;
	}

	public void setImageDate(String imageDate) {
		this.imageDate = imageDate;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getPostKey() {
		return postKey;
	}

	public void setPostKey(String postKey) {
		this.postKey = postKey;
	}

	public ImageMetaData(String imageID, String imageName, String imageSize, String imageFormat, String imageDate,
			String resolution, String postKey) {
		super();
		this.imageID = imageID;
		this.imageName = imageName;
		this.imageSize = imageSize;
		this.imageFormat = imageFormat;
		this.imageDate = imageDate;
		this.resolution = resolution;
		this.postKey = postKey;
	}

	@Override
	public String toString() {
		return "ImageMetaData [imageID=" + imageID + ", imageName=" + imageName + ", imageSize=" + imageSize
				+ ", imageFormat=" + imageFormat + ", imageDate=" + imageDate + ", resolution=" + resolution
				+ ", postKey=" + postKey + "]";
	}
	
	


	
	
	

}
