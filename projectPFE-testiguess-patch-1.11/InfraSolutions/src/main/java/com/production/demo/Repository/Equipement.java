package com.production.demo.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Equipement extends JpaRepository<com.production.demo.Model.Equipement,Long> {
	 
	@Query("SELECT e.id "
			+ "FROM Equipement e "
			+ "JOIN e.reseau r "
			+ "WHERE r.id=:rId")
	public List<Long> equipParRes(@Param("rId") Long rId);
}
