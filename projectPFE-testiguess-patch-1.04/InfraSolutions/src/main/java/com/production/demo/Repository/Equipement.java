package com.production.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Equipement extends JpaRepository<com.production.demo.Model.Equipement,Long> {
	 
}
