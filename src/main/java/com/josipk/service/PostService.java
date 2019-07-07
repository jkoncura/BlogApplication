package com.josipk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josipk.entity.Post;
import com.josipk.entity.User;
import com.josipk.repository.PostRepo;

@Service
public class PostService {
	
	@Autowired
	private PostRepo postRepository;
	
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}
	public void savePost(Post post) {
		postRepository.save(post);
	}
	public List<Post> findByUser(User user){
        return postRepository.findByCreatorId(user.getId());
    }

    public boolean deletePost(Long postId){
        Optional<Post> thePost = postRepository.findById(postId);
        if(!thePost.isPresent())
            return false;
        postRepository.deleteById(postId);
        return true;
    }

    public Post getPost(Long id) {
    	Optional<Post> thePost = postRepository.findById(id);
        return thePost.get();
    }
}
