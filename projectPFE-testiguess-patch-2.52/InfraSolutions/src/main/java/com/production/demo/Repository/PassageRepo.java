package com.production.demo.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.production.demo.Model.Passage;

@Repository
public interface PassageRepo extends JpaRepository<Passage,Long> {
	
	@Query("SELECT ve.id, ve.longueur, ve.numEssieu,"
				 + "p.date, p.time, p.classe, p.speed, p.headway, p.overloaded, "
				 + "v.numero, v.sens "
			
				+ "FROM Passage p "
			
				+ "JOIN p.vehicule ve "
				+ "JOIN p.voie v "
				+ "JOIN p.equip e "
				+ "JOIN e.reseau r "
			
				+ "WHERE r.id=:rId "
				+ "AND e.id=:id "
				+ "AND e.mode=:mode "
				+ "AND p.timestamp between :timestamp1 AND :timestamp2 "
				+ "AND p.typePoid is not :typePoid"
			)
	public Optional<List<Object[]>> findVolumeByPeriode(@Param("rId")Long rId,@Param("id")Long eid ,@Param("mode")String mode,  @Param("timestamp1")LocalDateTime times1,@Param("timestamp2")LocalDateTime times2, @Param("typePoid")String typeP);
	
	@Query("SELECT DISTINCT r.route, count(p) "
			
		+  "FROM Passage p  "
		+  "JOIN p.voie v "
		+  "JOIN v.reseau r "
		+  "JOIN p.equip e "
		
		+  "WHERE p.date BETWEEN :date1 AND :date2 "
		+  "AND   p.time BETWEEN :time1 AND :time2 "
		
		+  "GROUP BY r.route "
		)
	//Optional(Groupement) OR TypePoids
	public Optional<Map<String,Integer>> volumeParRoute(@Param("date1")Date date1,@Param("date2")Date date2,
			@Param("time1")Date time1,@Param("time2")Date time2);
			//@Param("rId")Long rId,@Param("id")Long id, @Param("mode")String mode
		
	public List<Passage> findAll();
			

}
