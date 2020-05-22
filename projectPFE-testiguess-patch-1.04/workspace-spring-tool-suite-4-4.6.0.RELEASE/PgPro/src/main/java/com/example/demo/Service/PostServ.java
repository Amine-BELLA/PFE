package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Post;
import com.example.demo.Repository.PostRepo;

@Service
public class PostServ {

	PostRepo postRepo;

	public PostRepo getPostRepo() {
		return postRepo;
	}
	@Autowired
	public void setPostRepo(PostRepo postRepo) {
		this.postRepo = postRepo;
	}
	
	public Optional<Post> getPost(Long id){
		return postRepo.findById(id);
	}
}
