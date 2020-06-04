package com.production.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.production.demo.Model.Reseau;

public interface ReseauRepo extends JpaRepository<Reseau, Long> {

	@Query("SELECT r.id "
			+ "FROM Reseau r ")
	public List<Long> allReseau();
}
