package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Post;
import com.example.demo.Model.Utilisateur;
import com.example.demo.Service.PostServ;
import com.example.demo.Service.UtilisateurServ;

@RestController
public class UtilisateurCont {
	

	private UtilisateurServ utilisateurServ;
	private PostServ postServ;
	
	
	public PostServ getPostServ() {
		return postServ;
	}
	@Autowired
	public void setPostServ(PostServ postServ) {
		this.postServ = postServ;
	}
	public UtilisateurServ getUtilisateurServ() {
		return utilisateurServ;
	}
	@Autowired
	public void setUtilisateurServ(UtilisateurServ utilisateurServ) {
		this.utilisateurServ = utilisateurServ;
	}
	@GetMapping("/users")
	public List<Utilisateur> getAll(){
		return utilisateurServ.showAll();
	}
	@PostMapping("/users")
	public Utilisateur putUser(@RequestBody Utilisateur u) {
		return utilisateurServ.putUser(u);
	}
	
	@GetMapping("/users/{id}/{postId}")
	public List<Object> findUserPostById(@PathVariable("id") Long userId, @PathVariable("postId") Long postId){
		return utilisateurServ.findUserPost(userId, postId);
	}
	@GetMapping("/users/posts/{id}")
	public Optional<List<Post>> getUserPosts(@PathVariable Long id){
		return utilisateurServ.getAllUserPosts(id);
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id) {
		utilisateurServ.removeUser(id);
		return ("Delete Complete of User whose ID ="+id);
	}
	@GetMapping("/posts/{id}")
	public Optional<Post> getPost(@PathVariable Long id){
		Optional<Post>  post = postServ.getPost(id);
		if(post.isPresent()) {
			return post;
		}
		return Optional.ofNullable(new Post());
	}

}
