package com.bptn.service;


// mesed with with feeed controller 
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedService {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	FeedRepository feedRepository; 
	
	
		
		List<Post>getPostsbyUsername( String username){
			
			List<Post>posts = this.feedRepository.findByuserID(new UserID(username));
			
			return posts; 
			
			posts = this.removeEmptyPosts(posts); 
			
		}
		
	
	
		 List<Post>removeEmptyPosts(List<Post>posts){
			 
			 posts.removeIf(p -> p.getPostType()==null || p.getPostType().isEmpty());
			 
			 return posts; 
		 }

		
	}


