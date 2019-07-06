package com.josipk.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.josipk.entity.Post;
import com.josipk.service.PostService;

@RestController
public class BlogController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	@GetMapping(value = "/posts")
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}
	@PostMapping(value = "/post")
	public void publishPost(@RequestBody Post post) {
		if(post.getDateCreated() == null) {
			post.setDateCreated(new Date());
		}
		postService.savePost(post);
	}
}
