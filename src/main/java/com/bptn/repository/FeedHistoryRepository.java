package com.bptn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.models.History;
import com.bptn.models.UserID;

@Repository
public interface FeedHistoryRepository extends JpaRepository<History, String> {
	
	
	List<History> findByUserID(UserID userID);
	List<History> findByPostType(String postType); 
	//List<History> findByPostId(String postID);  not needed
	//List<History> findByPostType(String postType); 
	
	@Transactional 
	void deleteByPostType(String postType); 
	
	
}
