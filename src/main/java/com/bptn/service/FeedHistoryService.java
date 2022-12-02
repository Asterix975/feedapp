package com.bptn.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidPostException;
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
	
	public List<History> getPostsByUsername(String username) {   //username when called from Postman must exist
		List<History> historyOfPosts = this.feedHistoryRepository.findByUserID(new UserID(username)); 
		return historyOfPosts; 
		
	}
	
	public Optional<History> getPostsByPostId(String PostID) { //must exists when called from postman
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
	
	public void validatePostID(String postID)throws InvalidPostException{
		Optional<History> opt = this.feedHistoryRepository.findById(postID);
		if (opt.isEmpty()) {
			logger.debug("PostID={} does not exist", postID); 
			throw new InvalidPostException ("This postID does not exist");
		} else {
			logger.debug("PostID={} validated",postID);
		}
		
	}
	
	public void validatePostType ( String postType) throws InvalidPostException{
		List<History> opt = this.feedHistoryRepository.findByPostType(postType);
		if (opt.isEmpty()) {
			logger.debug("PostType={} does not exist", postType); 
			throw new InvalidPostException ("This PostType does not exist");
		}else {
			logger.debug("PostType={} validated", postType); 
		}
		
	}
	//have the exceptions( from this.feedHistoryRepository ( above)

}
