package com.bptn.service;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.models.Post;
import com.bptn.models.UserID;
import com.bptn.repository.FeedRepository;

@Service
public class FeedService {
	
	
	@Autowired
	FeedRepository feedRepository; 
	
	
		
		public List<Post>getPostsbyUsername( String username){      //getPostsbyUsername() method 
			
		    List<Post> posts = this.feedRepository.findByUserID(new UserID(username));
			
			posts = this.removeEmptyPosts(posts); 
			
			return posts; 
			
		}
		
		// getPostsbyPostId() 
		
        public Optional<Post> getPostsbyPostID( String postID){    
			
		    Optional<Post> posts = this.feedRepository.findById(postID);
			
			//posts = this.removeEmptyPosts(posts); 
			
			return posts; 
			
        }
		
		//getPostsbyPostType() ;
        
   public List<Post> getPostsbyPostType( String postType){    
			
		    List<Post> posts = this.feedRepository.findBypostType(postType);
			
			//posts = this.removeEmptyPosts(posts); // removes post that are empty ( can apply on this method) 
			
			return posts; 
	
   }
	
          //removeEmptyPosts() method.  
		 List<Post>removeEmptyPosts(List<Post>posts){  
			 
			 posts.removeIf(p -> p.getPostType()==null || p.getPostType().isEmpty());
			 
			 return posts; 
		 }

		
	}


