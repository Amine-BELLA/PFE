package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {

@Query("select po.postDetail,u.first_name,u.last_name from Posts po inner join  po.user u where po.id = :postId AND u.id=:userId")
public List<Object> findPost(@Param("userId")Long userId,@Param("postId") Long postId);
}

  