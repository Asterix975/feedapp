package com.bptn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.models.userID;

@Repository 
public interface LogInRepository extends JpaRepository<userID, String> {

}

