package com.josipk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josipk.entity.Post;
import com.josipk.repository.PostRepo;

@Service
public class PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	public List<Post> getAllPosts() {
		return postRepo.findAll();
	}
	public void savePost(Post post) {
		postRepo.save(post);
	}

}
