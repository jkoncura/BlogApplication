package com.josipk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.josipk.entity.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
	
	

}
