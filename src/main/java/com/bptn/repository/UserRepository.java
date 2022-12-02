package com.bptn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bptn.models.UserID;

@Repository 
public interface UserRepository extends JpaRepository<UserID, String> {
	@Query(value = "select * from public.\"UserID\" where username=?1", nativeQuery = true)
	UserID findByUsername(String userName);

}

