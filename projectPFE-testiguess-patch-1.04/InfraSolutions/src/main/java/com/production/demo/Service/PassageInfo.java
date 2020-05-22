package com.production.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

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
			LocalDateTime finTime, String typeP, String[] classes, String sens) {
		List<VolumeParResponseObject> m = passageRepo.findVolumeParClasse(rId, eId, mode, debutTime, finTime, typeP,
				classes, sens);
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
			LocalDateTime finTime, String typeP, String sens) {
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
			LocalDateTime finTime, String typeP, String classe, String sens) {
		List<Object[]> m = passageRepo.grapheVolumeParClasse(rId, eId, mode, debutTime, finTime, typeP, classe, sens);
		return m;
	}

	// GrapheVolumeParVitesse
	public List<Object[]> grapheVolumeParVitesse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String sens) {
		List<Object[]> m = passageRepo.grapheVolumeParVitesse(rId, eId, mode, debutTime, finTime, typeP, sens);
		return m;
	}

	// GrapheVolumeParRoute
	public List<Object[]> grapheVolumeParRoute(Long rId, String mode, Long eId, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParRoute(rId, mode, eId, debutTime, finTime, typeP);
		return m;
	}

	// GrapheVolumeParVoie
	public List<Object[]> grapheVolumeParVoie(Long rId, String mode, Long eId, Long vId, LocalDateTime debutTime,
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
}
