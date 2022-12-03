package com.bptn.repository;

import com.bptn.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Post, String> {
	
    List<Post> findAllByUsernameKey(String username);

    Post findById(long postID);

    Post findByPostType(String postType);

}


//package com.bptn.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.bptn.models.Post;
//import com.bptn.models.UserID;
//
//@Repository
//public interface FeedRepository extends JpaRepository<Post, String> {
//
//	
//	List<Post> findByUserID(UserID userID); //replaced findbyusername in step 2
//	List<Post> findBypostType(String postType); 
//	//List<Post> findbypostID(String postID); //postID is the priamry key in the table( redundant) 
//	
//}
