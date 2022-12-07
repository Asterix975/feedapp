package com.bptn.controller;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.Post;
import com.bptn.request.CreatePostRequest;
import com.bptn.service.FeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FeedController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FeedService feedService;

    @GetMapping(value = "/")
    public ResponseEntity<String> ping() {
        LOGGER.debug("Executing ping()");
        return new ResponseEntity("Feed App up and running", HttpStatus.OK);
    }

    @GetMapping(value = "/Posts/username/{username}")
    public ResponseEntity<Object> getPostsByUsername(@PathVariable("username") String username) {
        LOGGER.debug("Executing getPostsByUsername API");
        List<Post> feeds;
        try {
            feeds = feedService.getPostsByUsername(username);
        } catch (InvalidUserNameException e) {
            LOGGER.error("Unable to find Post by Username, cause={}", e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(feeds, HttpStatus.OK);
    }

    @GetMapping(value = "/Posts")
    public ResponseEntity<Object> getAllPost(@RequestParam String excludeUsername) {
        LOGGER.debug("Executing getAllPost API and excluding user = {}", excludeUsername);
        List<Post> feeds = feedService.getAllPost(excludeUsername);
        return new ResponseEntity<>(feeds, HttpStatus.OK);
    }


    @PostMapping(value = "/Posts/username/{username}")
    public ResponseEntity<Object> createUserPost(@PathVariable("username") String username, @RequestBody CreatePostRequest createPostRequest) {
        LOGGER.debug("Executing createUserPost API");
        Post feed = feedService.createUserPost(username, createPostRequest);
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }


    @GetMapping(value = "/Posts/postID/{postID}")
    public ResponseEntity<Object> getPostsByPostId(@PathVariable("postID") long postID) {
        LOGGER.debug("Executing getPostsByPostId API");
        Post feed;
        try {
            feed = feedService.getPostsByPostId(postID);
        } catch (InvalidPostException e) {
            LOGGER.error("Unable to find Post by postID, cause={}", e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }

    @GetMapping(value = "/Posts/postType/{postType}")
    public ResponseEntity<Object> getPostsByPostType(@PathVariable("postType") String postType) {
        LOGGER.debug("Executing getPostsByPostType API");
        List<Post> feed;
        try {
            feed = feedService.getPostsByPostType(postType);
        } catch (InvalidPostException e) {
            LOGGER.error("Unable to find Post by postType, cause={}", e.getCause());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(feed, HttpStatus.OK);
    }
}



//package com.bptn.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bptn.models.Post;
//import com.bptn.service.FeedService;
//
//@RestController 
//public class FeedController {
//	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
//	
//	
//	/*@GetMapping("/ping")
//	public String ping() {
//		//System.out.println("ping executed"); // this will be excuted on the webpage 
//		logger.debug("Ping Executed!"); 
//		String str = "Feed App up and running"; 
//		return str; 
//	} */
//	
//		@Autowired
//		FeedService feedService;
//		
//		@GetMapping("/posts/username/{username}")
//		public List<Post> getPostsByUsername(@PathVariable("username") String username){
//		
//			logger.debug("Executing getPostsByUsername API");
//			
//	     	List<Post> posts = this.feedService.getPostsbyUsername(username);
//			
//	        return posts;
//		}
//		
//		
//		@GetMapping("/posts/postId/{postId}")
//		public Post getPostsByPostID(@PathVariable("postId") String postID){
//		
//			logger.debug("Executing getPostsBypostID API");
//			
//	     	Post posts = this.feedService.getPostsByPostID(postID);
//			
//	        return posts;
//	        
//		}
//		
//		@GetMapping("/Posts/postType/{postType}")
//		public List<Post> getPostsByPostType(@PathVariable("postType") String postType){
//		
//			logger.debug("Executing getPostsBypostType API");
//			
//	     	List<Post> posts = this.feedService.getPostsbyPostType(postType);
//			
//	        return posts;
//	        
//		}
//
//
//	
//	//class example on calculator 
//	
//	@GetMapping("/calc/{num1}/{num2}/{operator}")
//	public double calculator(@PathVariable("num1") double num1,
//			                 @PathVariable("num2") double num2,
//			                 @PathVariable("operator") String operator) {
//		
//		logger.debug("Calculator Running!");
//
//		double result = 0.0;
//	
//	    switch(operator) {
//	    case "+":
//	    	result =  num1 + num2;
//	    	break;
//	    case "-":
//	    	result =  num1 - num2;
//	    	break;
//	    case "*":
//	    	result =  num1 * num2;
//	    	break;
//	    case "d":
//	    	result =  num1 / num2;
//	    	break;
//	    default:
//	    	throw new RuntimeException("Invalid Operation!!!");
//	    }
//	
//	    logger.debug("Result: {}", result);
//
//	    return result;
//	}
//	
//	
//	
//}
