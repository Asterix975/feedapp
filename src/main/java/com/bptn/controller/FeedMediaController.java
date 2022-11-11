package com.bptn.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.models.ImageMetaData;
import com.bptn.service.FeedMediaService;

import request.FeedMediaRequest;

@RestController 
public class FeedMediaController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedMediaService feedMediaService; 
	
	@GetMapping ("/ImageMetaData/{postKey}") // "/ImageMetaData/{postKey}"   //  /postKey
	  public ImageMetaData getImageMediaByPostKey(@PathVariable ("postKey") String postKey) {
		
		logger.debug("Executing getmediaByPostKey API"); 
		ImageMetaData imageMetaData = this.feedMediaService.getImageMediaByPostKey(postKey); 
		return imageMetaData; 
		
	}
	@GetMapping ("/ImageMetaData1/{imageID}") // "/ImageMetaData/{imageID}" // /imageID
	public Optional<ImageMetaData> getPostsImageMediaByImageId(@PathVariable ("imageID") String imageID) {
		 
		logger.debug("Executing getPostsImageMediaByImageId API");
		Optional<ImageMetaData> imageMetaData = this.feedMediaService.getPostsImageMediaByImageId(imageID);
		return imageMetaData; 
		
	}
	
	@PostMapping ("/ImageMetaData2/{createImage}")  //supply this on postman, with the feedmediarequest attributes 
	public ImageMetaData createNewImage(@RequestBody  FeedMediaRequest request ) {
		logger.debug("Executing createNewImage API"); 
		ImageMetaData imageMetaData = this.feedMediaService.createNewImage(request);
		return imageMetaData; 
		
	}
}

