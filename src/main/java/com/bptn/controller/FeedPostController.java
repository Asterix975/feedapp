package com.bptn.controller;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.exceptions.InvalidRequestException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.Post;
import com.bptn.models.UserID;
import com.bptn.service.FeedPostService;
import com.bptn.service.UserService;

import request.FeedPostRequest;


@RestController 
public class FeedPostController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedPostService feedPostService; 
	
	@Autowired
	UserService userService; 
	
	@PostMapping ("/posts/feed/create")
	public ResponseEntity<?>saveFeed(@RequestBody FeedPostRequest request) {
		
		logger.debug("Executing saveFeed API"); 
		
		try {
			this.validateRequest(request);
			
			this.userService.userValidation(request.getUsername());
			
			Post feed = this.feedPostService.getPostFormNewsAndSavePost(request);
			logger.debug("Post Saved Succesfully"); 
			
			return new ResponseEntity<>(feed, HttpStatus.OK);
		} catch (InvalidRequestException | InvalidUserNameException ex) {
			
			//logger.error(Arrays.toString(ex.getStackTrace()));
			logger.error(ex.getMessage(),ex); 
			//e.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage()); 
		}
		//return this.feedPostService.getPostFormNewsAndSavePost(request); 	
	
	}
	
	@PostMapping ("/posts/feed/create2")
	public Post saveFeed2(@RequestBody FeedPostRequest request) 
	    throws InvalidRequestException, InvalidUserNameException{
		
		logger.debug("Executing saveFeed2 API"); 
		
			this.validateRequest(request);
			
			this.userService.userValidation(request.getUsername());
			
			Post feed = this.feedPostService.getPostFormNewsAndSavePost(request);
			logger.debug("Post Saved Succesfully"); 
		
			return feed; 
		}
	
	
	public void validateRequest(FeedPostRequest request) throws InvalidRequestException {
		
		if (!StringUtils.hasText(request.getFromDate()) ||
				!StringUtils.hasText(request.getToDate())) {
			throw new InvalidRequestException("Invalid Request: From Date or To Date are required");
		
		}
	}
	//Below is another sample method like the one above if one doesnt want to use stringutil, although
	//the above method is preffered, cleaner code
/*private void validateRequest2(FeedPostRequest request) throws InvalidRequestException {
		if ( (request.getFromDate()!=null && request.getFromDate().trim().isBlank()) ||
			 (request.getToDate()!=null && request.getToDate().trim().isBlank())) {
			throw new InvalidRequestException("Invalid request: FromDate and ToDate are required");
		}	
	} */
	
}

