package com.bptn.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.models.History;
import com.bptn.models.UserID;
import com.bptn.repository.FeedHistoryRepository;

@Service
public class FeedHistoryService {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	UserService userService; 
	
	@Autowired
	FeedPostService feedPostService; 
	
	@Autowired
	FeedHistoryRepository feedHistoryRepository; 
	
	public List<History> getPostsByUsername(String username) {
		List<History> historyOfPosts = this.feedHistoryRepository.findByUserID(new UserID(username)); 
		return historyOfPosts; 
		
	}
	
	public Optional<History> getPostsByPostId(String PostID) {
		Optional<History> historyOfPosts = this.feedHistoryRepository.findById(PostID);
		return historyOfPosts; 
		
	}
	
	public List<History> getPostsByPostType(String PostType) {
		List<History >historyOfPosts = this.feedHistoryRepository.findByPostType(PostType);
		
		historyOfPosts = this.removeEmptyHistory(historyOfPosts); 
		return historyOfPosts; 
		
	}
	public List<History>removeEmptyHistory(List <History> historyOfPosts)  {
		historyOfPosts.removeIf(h ->h.getPostType()==null || h.getPostType().isEmpty()); 
		return historyOfPosts; 
		
	}
	
	public String deleteHistoryByPostType(String postType) {  
		
		List <History> postsHistory = getPostsByPostType (postType); 
		if (postsHistory.isEmpty()) {
			logger.debug("postType does not exists", postType);
			return ("Nothing to delete");
		} 
		this.feedHistoryRepository.deleteByPostType(postType); 
		return postType;
		
	}
	
	//have the exceptions( from this.feedHistoryRepository

}
