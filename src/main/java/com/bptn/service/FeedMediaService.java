package com.bptn.service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.models.ImageMetaData;
import com.bptn.models.Post;
import com.bptn.repository.FeedImageMetaDataRepository;

import request.FeedMediaRequest;

@Service
public class FeedMediaService {
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired 
	FeedImageMetaDataRepository feedImageDataRepository; 
	
	public ImageMetaData getImageMediaByPostKey(String postID) {
	 ImageMetaData imageMetaDatas = this.feedImageDataRepository.findByPost(new Post(postID));
	 return imageMetaDatas;
		
	}
	
	public Optional<ImageMetaData>getPostsImageMediaByImageId(String imageID){
		Optional <ImageMetaData> imageMetaData= this.feedImageDataRepository.findById(imageID); 
		return imageMetaData; 
	}
	
	public ImageMetaData createNewImage ( FeedMediaRequest request) { //ImageMetaData imageMetaData,Post post
		
		ImageMetaData newImage = new ImageMetaData();
		
		newImage.setImageID(this.generateFeedMetadataId(request)); 
		newImage.setImageName(request.getImageName());
		newImage.setImageFormat(request.getImageFormat());
		newImage.setImageSize(request.getImageSize()); 
		newImage.setImageDate(LocalDate.now().toString()); 
		newImage.setResolution(request.getImageResolution()); 
		newImage.setPost(new Post(request.getPostID())); 
		 
		return this.feedImageDataRepository.save(newImage);  
		
	}
	private String generateFeedMetadataId(FeedMediaRequest request) {
		Random random = new Random( System.currentTimeMillis());
		StringBuilder imageIdBuilder = new StringBuilder();
		
		imageIdBuilder.append(random.nextInt());
		imageIdBuilder.append(Objects.hashCode(request.getPostID())); 
		
		String imageId = imageIdBuilder.toString();
		if (imageId.startsWith("-")) {
			imageId = imageId.substring(1); 
		}
		
		logger.debug("Generated image ID: {}", imageId);
		return imageId; 
		
	}

}

