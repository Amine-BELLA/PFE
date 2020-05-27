package com.production.demo.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.JsonHolder.VolumeParResponseParRoute;
import com.production.demo.Model.Passage;

@Repository
public interface PassageRepo extends JpaRepository<Passage, Long> {

	// ******** Resultat sous forme Tableau ********

	// VolumeParPeiode Table
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseObject( ve.id, ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time, p.classe, p.speed as vitesse, p.headway, p.overloaded as surcharge, "
			+ "v.numero as voie, v.sens) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid")
	public List<VolumeParResponseObject> findVolumeParPeriode(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP);

	// VolumeParClasse Table
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseObject( ve.id, ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time, p.classe, p.speed as vitesse, p.headway, p.overloaded as surcharge, "
			+ "v.numero as voie, v.sens) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.classe in :classes "
			+ " AND v.numero IN :voies")
	public List<VolumeParResponseObject> findVolumeParClasse(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("classes") String[] classes, @Param("voies") int[] voies);

	// VolumeParVitesse Table
	// ********TODO

	// VolumeParRoute Table
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseParRoute( e.id as equipementID ,ve.id as véhiculeID,"
			+ " ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time as Heure, p.classe, p.speed as vitesse, p.headway, p.overloaded as surcharge, "
			+ "v.numero as voie, v.sens) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.mode=:mode " + "AND p.timestamp between :timestamp1 AND :timestamp2 "
			+ "AND p.typePoid is not :typePoid " + " AND e.id IN :eIds")
	public List<VolumeParResponseParRoute> findVolumeParRoute(@Param("rId") Long rId, @Param("eIds") Long[] eIds,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP);

	// VolumeParVoie Table
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseParRoute( e.id as equipementID ,ve.id as véhiculeID,"
			+ " ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time as Heure, p.classe, p.speed as vitesse, p.headway, p.overloaded as surcharge, "
			+ " v.numero as voie , v.sens ) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.mode=:mode " + " AND e.id=:eId "
			+ " AND p.timestamp between :timestamp1 AND :timestamp2 "
			+ "AND p.typePoid is not :typePoid AND v.numero IN :voies")
	public List<VolumeParResponseParRoute> findVolumeParVoie(@Param("rId") Long rId, @Param("eId") Long eId,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP, @Param("voies") int[] voies);

	// VolumeParSens Table
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseParRoute( e.id as equipementID ,ve.id as véhiculeID,"
			+ " ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time as Heure, p.classe, p.speed as vitesse, p.headway, p.overloaded as surcharge, "
			+ " v.numero as voie , v.sens ) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.mode=:mode " + " AND e.id=:eId "
			+ " AND p.timestamp between :timestamp1 AND :timestamp2 "
			+ "AND p.typePoid is not :typePoid AND v.sens IN :sens")
	public List<VolumeParResponseParRoute> findVolumeParSens(@Param("rId") Long rId, @Param("eId") Long eId,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP, @Param("sens") String[] sens);

	// ******** Resultat sous forme Graphique ********
	// VolumeParPeriode
	@Query("SELECT p.date , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "

			+ "GROUP BY p.date ")
	public List<Object[]> grapheVolumeParPeriode(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP);

	// VolumeParClasse
	@Query("SELECT p.timestamp, count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.classe=:classe "
			+ "AND v.numero IN :voie " + "GROUP BY p.timestamp ")
	public List<Object[]> grapheVolumeParClasse(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("classe") String classe, @Param("voie") int[] voie);

	// VolumeParVitesse
	@Query("SELECT p.speed , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "
			+ "AND v.sens=:sens "

			+ "GROUP BY p.speed ")
	public List<Object[]> grapheVolumeParVitesse(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP, @Param("sens") String sens);

	// VolumeParRoute
	@Query("SELECT p.timestamp , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId AND e.mode=:mode " + "AND p.timestamp between :timestamp1 AND :timestamp2 "
			+ "AND p.typePoid is not :typePoid AND e.id=:eId "

			+ "GROUP BY p.timestamp")
	public List<Object[]> grapheVolumeParRoute(@Param("rId") Long rId, @Param("mode") String mode,
			@Param("eId") Long eId, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP);

	// VolumeParVoie
	@Query("SELECT p.timestamp , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId AND e.mode=:mode AND e.id=:eId " + "AND p.timestamp between :timestamp1 AND :timestamp2 "
			+ "AND p.typePoid is not :typePoid AND v.numero=:vNum "

			+ "GROUP BY p.timestamp")
	public List<Object[]> grapheVolumeParVoie(@Param("rId") Long rId, @Param("mode") String mode,
			@Param("eId") Long eIds, @Param("vNum") int vId, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP);

	// VolumeParSens
	@Query("SELECT p.timestamp , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId AND e.mode=:mode AND e.id=:eId " + "AND p.timestamp between :timestamp1 AND :timestamp2 "
			+ "AND p.typePoid is not :typePoid AND v.sens=:sens "

			+ "GROUP BY p.timestamp")
	public List<Object[]> grapheVolumeParSens(@Param("rId") Long rId, @Param("mode") String mode,
			@Param("eId") Long eIds, @Param("sens") String sens, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("typePoid") String typeP);

	// ****** Menu Véhicule *******
	// Table
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseObject(ve.id, ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time, p.classe, p.speed as vitesse, p.headway, p.overloaded as surcharge, "
			+ "v.numero as voie, v.sens) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.speed between :speed1 AND :speed2 "
			+ "AND ve.longueur between :long1 AND :long2")

	public List<VolumeParResponseObject> vehiculeTable(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("timestamp1") LocalDateTime times1,
			@Param("timestamp2") LocalDateTime times2, @Param("speed1") int speed1, @Param("speed2") int speed2,
			@Param("long1") int long1, @Param("long2") int long2);

	// Graphe Poids Lourd/Poid Total

	@Query("SELECT HOUR(p.time) , count(p) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "

			+ "GROUP BY HOUR(p.time) ")
	public List<Object[]> graphePlPt(@Param("rId") Long rId, @Param("id") Long eid, @Param("mode") String mode,
			@Param("timestamp1") LocalDateTime times1, @Param("timestamp2") LocalDateTime times2,
			@Param("typePoid") String typeP);

	// Vitesse Menu
	// Vtesse Table
	// *****

	// Vitesse periode Graphe
	@Query("SELECT HOUR(p.time) , AVG(p.speed) as nombreDeVehicule "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "
			+ " AND v.sens=:sens "

			+ "GROUP BY HOUR(p.time) ")
	public List<Object[]> vitesseParH(@Param("rId") Long rId, @Param("id") Long eid, @Param("mode") String mode,
			@Param("timestamp1") LocalDateTime times1, @Param("timestamp2") LocalDateTime times2,
			@Param("typePoid") String typeP, @Param("sens") String sens);

	@Query("SELECT p.date , SUM(p.speed),count(p)  "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.typePoid is not :typePoid "
			+ "AND v.sens=:sens "

			+ "GROUP BY p.date ")
	public List<Object[]> vitesseParJ(@Param("rId") Long rId, @Param("id") Long eid, @Param("mode") String mode,
			@Param("timestamp1") LocalDateTime times1, @Param("timestamp2") LocalDateTime times2,
			@Param("typePoid") String typeP, @Param("sens") String sens);

	// Vitesse Classe Graphe
	@Query("SELECT AVG(p.speed)"

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode "
			+ "AND p.timestamp between :timestamp1 AND :timestamp2 " + "AND p.classe=:classe " + "AND v.numero=:voie "
			+ "GROUP BY p.classe")
	public List<Double> vitesseParClasse(@Param("rId") Long rId, @Param("id") Long eid, @Param("mode") String mode,
			@Param("timestamp1") LocalDateTime times1, @Param("timestamp2") LocalDateTime times2,
			@Param("classe") String classe, @Param("voie") int voie);

	// Vitesse Route Graphe
	@Query("SELECT AVG(p.speed) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId AND e.mode=:mode " + "AND p.timestamp between :timestamp1 AND :timestamp2 "
			+ "AND p.typePoid is not :typePoid AND e.id=:eId "

			+ "GROUP BY e.id")
	public List<Double> vitesseParRoute(@Param("rId") Long rId, @Param("mode") String mode, @Param("eId") Long eId,
			@Param("timestamp1") LocalDateTime times1, @Param("timestamp2") LocalDateTime times2,
			@Param("typePoid") String typeP);

	// Temps Réel
	@Query("SELECT new com.production.demo.JsonHolder.VolumeParResponseObject( ve.id, ve.longueur, ve.numEssieu as nombreEssieu,"
			+ "p.date, p.time,p.gross as poids_total,p.gap, p.classe, p.speed as vitesse, p.headway, p.overloaded as surcharge, "
			+ "v.numero as voie, v.sens) "

			+ "FROM Passage p "

			+ "JOIN p.vehicule ve " + "JOIN p.voie v " + "JOIN p.equip e " + "JOIN e.reseau r "

			+ "WHERE r.id=:rId " + "AND e.id=:id " + "AND e.mode=:mode " + "AND v.numero IN :numero")
	public List<VolumeParResponseObject> tempReel(@Param("rId") Long rId, @Param("id") Long eid,
			@Param("mode") String mode, @Param("numero") int[] num);

	// Voie in a Reseau
	@Query("SELECT  v.sens " + "FROM Voie v " + "JOIN v.reseau r " + "WHERE r.id=:id")
	public List<String> voiesParReseau(@Param("id") Long id);

}