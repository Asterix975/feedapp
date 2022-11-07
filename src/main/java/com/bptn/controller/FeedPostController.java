package com.bptn.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.models.Post;
import com.bptn.service.FeedPostService;

import request.FeedPostRequest;


@RestController 
public class FeedPostController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedPostService feedPostService; 
	
	
	@PostMapping ("/posts/feed/create")
	public Post saveFeed(@RequestBody FeedPostRequest request) {
		
		logger.debug("Executing saveFeed API"); 
		
		return this.feedPostService.getPostFormNewsAndSavePost(request); 	
	
	}

	

}
