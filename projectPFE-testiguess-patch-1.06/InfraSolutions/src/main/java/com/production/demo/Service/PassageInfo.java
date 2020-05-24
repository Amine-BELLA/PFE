package com.production.demo.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.JsonHolder.VolumeParResponseParRoute;
import com.production.demo.Repository.PassageRepo;

@Service
public class PassageInfo {

	@Autowired
	private PassageRepo passageRepo;

	// VolumeParPeriode
	public List<VolumeParResponseObject> volumeParPeriode(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<VolumeParResponseObject> m = passageRepo.findVolumeParPeriode(rId, eId, mode, debutTime, finTime, typeP);
		return m;
	}

	// VolumeParClasse
	public List<VolumeParResponseObject> volumeParClasse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String[] classes, int[] voies) {
		List<VolumeParResponseObject> m = passageRepo.findVolumeParClasse(rId, eId, mode, debutTime, finTime, typeP,
				classes, voies);
		return m;
	}

	// VolumeParRoute
	public List<VolumeParResponseParRoute> volumeParRoute(Long rId, Long[] eIds, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<VolumeParResponseParRoute> m = passageRepo.findVolumeParRoute(rId, eIds, mode, debutTime, finTime, typeP);
		return m;
	}

	// VolumeParVoie
	public List<VolumeParResponseParRoute> volumeParVoie(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, int[] voies) {
		List<VolumeParResponseParRoute> m = passageRepo.findVolumeParVoie(rId, eId, mode, debutTime, finTime, typeP,
				voies);
		return m;
	}

	// VolumeParSens
	public List<VolumeParResponseParRoute> volumeParSens(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String[] sens) {
		List<VolumeParResponseParRoute> m = passageRepo.findVolumeParSens(rId, eId, mode, debutTime, finTime, typeP,
				sens);
		return m;
	}

	// ***** Graphes

	// GrapheVolumeParPeriode
	public List<Object[]> grapheVolumeParPeriode(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParPeriode(rId, eId, mode, debutTime, finTime, typeP);
		return m;
	}

	// GrapheVolumeParClasse
	public List<Object[]> grapheVolumeParClasse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String classe, int[] voie) {
		List<Object[]> m = passageRepo.grapheVolumeParClasse(rId, eId, mode, debutTime, finTime, typeP, classe, voie);
		return m;
	}

	// GrapheVolumeParVitesse
	public Map<Integer, Integer> grapheVolumeParVitesse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String sens) {
		List<Object[]> m = new ArrayList<>();
		m = passageRepo.grapheVolumeParVitesse(rId, eId, mode, debutTime, finTime, typeP, sens);
		Map<Integer, Integer> v = new HashMap<>();
		v.put(10, 0);
		v.put(20, 0);
		v.put(30, 0);
		v.put(40, 0);
		v.put(50, 0);
		v.put(60, 0);
		v.put(70, 0);
		v.put(80, 0);
		v.put(90, 0);
		v.put(100, 0);
		v.put(110, 0);
		v.put(120, 0);
		v.put(130, 0);
		v.put(140, 0);
		v.put(150, 0);
		v.put(160, 0);
		v.put(170, 0);
		v.put(180, 0);
		for (int i = 0; i < m.size(); i++) {
			v.put(((int) m.get(i)[0] / 10) * 10,
					v.get(((int) m.get(i)[0] / 10) * 10) + ((Long) m.get(i)[1]).intValue());
		}
		Map<Integer, Integer> s = new TreeMap<>(v);
		return s;
	}

	// GrapheVolumeParRoute
	public List<Object[]> grapheVolumeParRoute(Long rId, String mode, Long eId, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParRoute(rId, mode, eId, debutTime, finTime, typeP);
		return m;
	}

	// GrapheVolumeParVoie
	public List<Object[]> grapheVolumeParVoie(Long rId, String mode, Long eId, int vId, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParVoie(rId, mode, eId, vId, debutTime, finTime, typeP);
		return m;
	}

	// GrapheVolumeParSens
	public List<Object[]> grapheVolumeParSens(Long rId, String mode, Long eId, String sens, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParSens(rId, mode, eId, sens, debutTime, finTime, typeP);
		return m;
	}

	// Menu Véhicule Table
	public List<VolumeParResponseObject> vehiculeTable(Long rId, String mode, Long eId, LocalDateTime debutTime,
			LocalDateTime finTime, int speed1, int speed2, int long1, int long2) {
		List<VolumeParResponseObject> m = passageRepo.vehiculeTable(rId, eId, mode, debutTime, finTime, speed1, speed2,
				long1, long2);
		return m;
	}

	// Menu Vehicule Graphe(PL/PT)
	public Map<String, List<Integer>> graphePlPt(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime) {
		// ResultSet From SQL Query
		Map<String, List<Object[]>> m = new HashMap<>();
		// Result {"key":[2,7,...]...}
		Map<String, List<Integer>> list = new HashMap<>();

		m.put("Poids Lourd", passageRepo.graphePlPt(rId, eId, mode, debutTime, finTime, "VL"));
		m.put("Poids Total", passageRepo.graphePlPt(rId, eId, mode, debutTime, finTime, "T"));

		
		for (String key : m.keySet()) {
			List<Integer> holder = new ArrayList<>();
			for (int i = 0; i < 24; i++) {
				holder.add(0);
			}
			List<Object[]> listHeure = m.get(key);
			for (Object[] o : listHeure) {
				holder.set((Integer) o[0], ((Long)o[1]).intValue());
			}
			list.put(key, holder);

		}

		return list;

	}
}
