package com.bptn.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.models.Post;
import com.bptn.service.FeedService;

@RestController 
public class FeedController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	
	/*@GetMapping("/ping")
	public String ping() {
		//System.out.println("ping executed"); // this will be excuted on the webpage 
		logger.debug("Ping Executed!"); 
		String str = "Feed App up and running"; 
		return str; 
	} */
	
		@Autowired
		FeedService feedService;
		
		@GetMapping("/posts/username/{username}")
		public List<Post> getPostsByUsername(@PathVariable("username") String username){
		
			logger.debug("Executing getPostsByUsername API");
			
	     	List<Post> posts = this.feedService.getPostsbyUsername(username);
			
	        return posts;
		}
		
		
		@GetMapping("/posts/postId/{postId}")
		public Post getPostsByPostID(@PathVariable("postId") String postID){
		
			logger.debug("Executing getPostsBypostID API");
			
	     	Post posts = this.feedService.getPostsByPostID(postID);
			
	        return posts;
	        
		}
		
		@GetMapping("/Posts/postType/{postType}")
		public List<Post> getPostsByPostType(@PathVariable("postType") String postType){
		
			logger.debug("Executing getPostsBypostType API");
			
	     	List<Post> posts = this.feedService.getPostsbyPostType(postType);
			
	        return posts;
	        
		}


	
	//class example on calculator 
	
	@GetMapping("/calc/{num1}/{num2}/{operator}")
	public double calculator(@PathVariable("num1") double num1,
			                 @PathVariable("num2") double num2,
			                 @PathVariable("operator") String operator) {
		
		logger.debug("Calculator Running!");

		double result = 0.0;
	
	    switch(operator) {
	    case "+":
	    	result =  num1 + num2;
	    	break;
	    case "-":
	    	result =  num1 - num2;
	    	break;
	    case "*":
	    	result =  num1 * num2;
	    	break;
	    case "d":
	    	result =  num1 / num2;
	    	break;
	    default:
	    	throw new RuntimeException("Invalid Operation!!!");
	    }
	
	    logger.debug("Result: {}", result);

	    return result;
	}
	
	
	
}
