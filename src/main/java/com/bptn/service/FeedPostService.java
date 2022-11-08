package com.bptn.service;

import java.util.Objects;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bptn.models.Post;
import com.bptn.models.UserID;
import com.bptn.repository.FeedPostRepository;

import request.FeedPostRequest;

@Service
public class FeedPostService {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); 
	
	
	@Value ( "${api.key}")
	String apiKey;
	
	@Value ( "${api.base.url}")
	String apiBaseUrl; 
	
	@Autowired  
	FeedPostRepository feedPostRepository; 
	
	@Autowired
	RestTemplate restTemplate; 
	
	
	/*  // need an object and that object will be from the controller 
	 {
	    "fromDate": "2022-10-13",
	    "toDate": "2022-11-07", 
	    "queryKeyword": "newyork"
	    "username": "carlos"
	 }
	 */


	public Post getPostFormNewsAndSavePost (FeedPostRequest request) {
	
		//Post feed  = new Post(); ( commeted out, anne question)
		
		/* 1. build the url of the request for newspapaer */
		// buildAPurl
		String url = this.buildAPIUrl(request); 
		
		/*2. send ther equest ot he newsapi and receive resposnce */
		//getFeedFromNewsAPI (step 7)
		
		String feedResult = getFeedFromNewsAPI(url);
		
		/* 3. store thed ata received in step 2 in postgressl
		 ///storefeed() (8)
		 */
		Post feed = storeFeed(feedResult, request); 
		return feed;  
	}
	
	private String buildAPIUrl(FeedPostRequest request) {
		StringBuilder urlBuilder = new StringBuilder();
		
		// https://newsapi.org/v2/everything
		//?q= tesla
		//&from=2022-10-07&
		//sortBy=publishedAt&apiKey=a970454c5837435a92d5313490c3152d
		
		urlBuilder.append(apiBaseUrl);
		urlBuilder.append("?q="); 
		urlBuilder.append(request.getQueryKeyword()); 
		
		
		if (request.getFromDate()!= null && !request.getFromDate().isEmpty()) {
			urlBuilder.append("&from=").append(request.getFromDate()); 
		}
		if (request.getToDate()!= null && !request.getToDate().isEmpty()) {
			urlBuilder.append("&to=").append(request.getToDate()); 
		}
		
		urlBuilder.append("&apikey=").append(apiKey);
		return urlBuilder.toString(); 
	}

	private String getFeedFromNewsAPI (String url) {
		String result = this.restTemplate.getForObject(url, String.class);
		return result; 
	}
	
	private Post storeFeed(String feedResult,FeedPostRequest request) {
		
		UserID userId = new UserID(request.getUsername()); 
		Post feed = new Post();
		
		//feed.setPost("Hello"); 
		feed.setPostType(feedResult); 
		feed.setUserID(userId);
		feed.setPostID(this.generatePostId(request)); 
		
		logger.debug("Feed to be stored: {}", feed);
		return this.feedPostRepository.save(feed); 
		
	}
	
	private String generatePostId ( FeedPostRequest request) {
		Random random = new Random( System.currentTimeMillis());
		StringBuilder postIdBuilder = new StringBuilder();
		postIdBuilder.append(random.nextInt());
		postIdBuilder.append(Objects.hashCode(request.getUsername()+ " " + request.getQueryKeyword())); 
		
		String postId = postIdBuilder.toString();
		if (postId.startsWith("_")) {
			postId = postId.substring(1);
		}
		return postId; 
	}
	
}
