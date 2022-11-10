package com.bptn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.models.ImageMetaData;
import com.bptn.models.Post;

@Repository 
public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {
	
	
	//ImageMetaData findByImageid(String imageID); // doesnt need to be included because its redundant 
	ImageMetaData findByPost(Post post);

}
