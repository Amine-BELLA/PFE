package com.production.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.production.demo.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	public Optional<User> findByEmail(String email);

}
