package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Post;
import com.example.demo.Model.Utilisateur;
import com.example.demo.Repository.UtilisateurRepo;

@Service
public class UtilisateurServ {
	
	@Autowired
	private UtilisateurRepo utilisateurRepo;
	
	
	public List<Utilisateur> showAll(){
		return utilisateurRepo.findAll();
	}
	public Utilisateur putUser(Utilisateur u) {
		return utilisateurRepo.save(u);
	}
	public List<Object> findUserPost(Long userId , Long postId){
		return utilisateurRepo.findPost(userId, postId);
	}
	public Optional<List<Post>> getAllUserPosts(Long userId){
		Optional<Utilisateur> user = utilisateurRepo.findById(userId);
		if(user.isPresent()) {
			 return Optional.of(user.get().getPosts());
		}
		return null;
	}
	public void removeUser(Long id) {
		utilisateurRepo.deleteById(id);
	}
}
