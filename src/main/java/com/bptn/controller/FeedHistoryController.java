package com.bptn.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.models.History;
import com.bptn.service.FeedHistoryService;

@RestController 
public class FeedHistoryController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	FeedHistoryService feedHistoryService; 
	
	@GetMapping("/history/username/{username}") 
	public List<History> getPostsByUsername(@PathVariable("username") String username){
	
		logger.debug("Executing getPostsByUsername API");
     	List<History> histories = this.feedHistoryService.getPostsByUsername(username);
        return histories;
   }
	
	@GetMapping("/history/postId/{postId}")
	public Optional<History> getPostsByPostID(@PathVariable("postId") String postID){
	
		logger.debug("Executing getPostsBypostID API");
     	Optional<History> histories = this.feedHistoryService.getPostsByPostId(postID);
        return histories;   
	} 
	
	@GetMapping("/history/postType/{postType}")
	public List<History> getPostsByPostType(@PathVariable("postType") String postType){
	
		logger.debug("Executing getPostsBypostType API");
     	List<History> histories = this.feedHistoryService.getPostsByPostType(postType);
        return histories; 
	}
	
	@DeleteMapping("/HistoryDelete/postType{postType}")
	public String deleteHistoryByPostType(@PathVariable ("postType") String postType) {
		logger.debug("Executing deletePostsByPostType API");
		String histories = this.feedHistoryService.deleteHistoryByPostType(postType);
		return histories;
	
}
	
	
}

