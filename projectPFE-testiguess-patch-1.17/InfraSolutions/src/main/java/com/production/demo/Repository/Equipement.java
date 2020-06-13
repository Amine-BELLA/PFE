package com.production.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.production.demo.JsonHolder.CartographieHolder;

@Repository
public interface Equipement extends JpaRepository<com.production.demo.Model.Equipement,Long> {
	 
	@Query("SELECT e.id "
			+ "FROM Equipement e "
			+ "JOIN e.reseau r "
			+ "WHERE r.id=:rId")
	public List<Long> equipParRes(@Param("rId") Long rId);
	
	@Query("SELECT new com.production.demo.JsonHolder.CartographieHolder(e.coorPK as coordonneePK, e.lat , e.lng as longitude , e.model, e.mode, r.route, " + 
		   " r.province, e.numSerie as numeroSerie, r.region) "
		+  " FROM Equipement e "
		+ "JOIN e.reseau r")
	public List<CartographieHolder> carteHolder();
	
	
}
