package com.production.demo.Controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.production.demo.Exceptions.ResourceNotFoundException;
import com.production.demo.JsonHolder.CartographieHolder;
import com.production.demo.JsonHolder.ParClasseVariables;
import com.production.demo.JsonHolder.ParClasseVariablesTable;
import com.production.demo.JsonHolder.ParRouteVariables;
import com.production.demo.JsonHolder.ParSensVariables;
import com.production.demo.JsonHolder.ParVitesseVariables;
import com.production.demo.JsonHolder.ParVoieVariables;
import com.production.demo.JsonHolder.RepeatingVariables;
import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.JsonHolder.VolumeParResponseParRoute;
import com.production.demo.Repository.Equipement;
import com.production.demo.Repository.PassageRepo;
import com.production.demo.Repository.ReseauRepo;
import com.production.demo.Service.PassageInfo;

@RestController
@CrossOrigin("*")
public class VolumeParAPIs {

	@Autowired
	private PassageInfo passageInfo;

	@Autowired
	private PassageRepo passageRepo;

	@Autowired
	private Equipement equipRepo;

	@Autowired
	private ReseauRepo resRepo;

	@PostMapping("/volumeParPeriode")
	public ResponseEntity<Object> volumeParPeriode(@Valid @RequestBody RepeatingVariables pr) {
		List<VolumeParResponseObject> m = passageInfo.volumeParPeriode(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParClasse")
	public ResponseEntity<Object> volumeParClasse(@Valid @RequestBody ParClasseVariablesTable pCv) {
		List<VolumeParResponseObject> m = passageInfo.volumeParClasse(pCv.resId, pCv.equipId, pCv.modeUtil,
				pCv.debutTime, pCv.finTime, pCv.classes, pCv.voie);
		if (m.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant pour ces classe" + pCv.classes),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParRoute")
	public ResponseEntity<Object> volumeParRoute(@Valid @RequestBody ParRouteVariables pr) {
		List<VolumeParResponseParRoute> m = passageInfo
				.volumeParRoute(pr.resId, pr.equipIds, pr.modeUtil, pr.debutTime, pr.finTime, pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParVoie")
	public ResponseEntity<Object> volumeParVoie(@Valid @RequestBody ParVoieVariables pr) {
		List<VolumeParResponseParRoute> m = passageInfo.volumeParVoie(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid, pr.vNums);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParSens")
	public ResponseEntity<Object> volumeParSens(@Valid @RequestBody ParSensVariables pr) {
		List<VolumeParResponseParRoute> m = passageInfo.volumeParSens(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid, pr.sense);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParPeriode")
	public ResponseEntity<Object> grapheVolumeParPeriode(@Valid @RequestBody RepeatingVariables pr) {
		List<Object[]> m = passageInfo.grapheVolumeParPeriode(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParClasse")
	public ResponseEntity<Object> grapheVolumeParClasse(@Valid @RequestBody ParClasseVariables pCv) {
		Map<String, List<Object[]>> map = new HashMap<>();
		for (String classe : pCv.classes) {
			map.put(classe, passageInfo.grapheVolumeParClasse(pCv.resId, pCv.equipId, pCv.modeUtil, pCv.debutTime,
					pCv.finTime, classe, pCv.voie));
		}
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant pour ces classe" + pCv.classes),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParVitesse")
	public ResponseEntity<Object> grapheVolumeParVitesse(@Valid @RequestBody ParVitesseVariables pVv) {
		Map<Integer, Integer> m = passageInfo.grapheVolumeParVitesse(pVv.resId, pVv.equipId, pVv.modeUtil,
				pVv.debutTime, pVv.finTime, pVv.typePoid, pVv.sens);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParRoute")
	public ResponseEntity<Object> grapheVolumeParRoute(@Valid @RequestBody ParRouteVariables pr) {
		Map<Long, List<Object[]>> map = new HashMap<>();
		for (Long eId : pr.equipIds) {
			map.put(eId, passageInfo.grapheVolumeParRoute(pr.resId, pr.modeUtil, eId, pr.debutTime, pr.finTime,
					pr.typePoid));
		}
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant dans ces routes durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/grapheVolumeParVoie")
	public ResponseEntity<Object> grapheVolumeParVoie(@Valid @RequestBody ParVoieVariables rV) {
		Map<Integer, List<Object[]>> map = new HashMap<>();
		for (int vNum : rV.vNums) {
			map.put(vNum, passageInfo.grapheVolumeParVoie(rV.resId, rV.modeUtil, rV.equipId, vNum, rV.debutTime,
					rV.finTime, rV.typePoid));
		}
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant dans cette route durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/grapheVolumeParSens")
	public ResponseEntity<Object> grapheVolumePar(@Valid @RequestBody ParSensVariables rV) {
		Map<String, List<Object[]>> map = new HashMap<>();
		for (String sens : rV.sense) {
			map.put(sens, passageInfo.grapheVolumeParSens(rV.resId, rV.modeUtil, rV.equipId, sens, rV.debutTime,
					rV.finTime, rV.typePoid));
		}
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant dans cette route durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	@PostMapping("/vehiculeTable")
	public ResponseEntity<Object> volumeTable(@Valid @RequestBody RepeatingVariables pr) {
		List<VolumeParResponseObject> m = passageInfo.vehiculeTable(pr.resId, pr.modeUtil, pr.equipId, pr.debutTime,
				pr.finTime, pr.speed1, pr.speed2, pr.long1, pr.long2);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/graphePlPt")
	public ResponseEntity<Object> graphePlPt(@Valid @RequestBody RepeatingVariables pr) {
		Map<String, List<Integer>> m = passageInfo.graphePlPt(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	////// MOCK
	@PostMapping("/graphePlPt1")
	public ResponseEntity<Object> graphePlPt1(@Valid @RequestBody RepeatingVariables pr) {
		List<Object[]> m = passageRepo.graphePlPt(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime, pr.finTime,
				pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/vitesseParPeriodeHoraire")
	public ResponseEntity<Object> vitesseParH(@Valid @RequestBody RepeatingVariables pr) {
		Map<String, List<Integer>> m = passageInfo.vitesseParH(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/vitesseParPeriodeJournaliere")
	public ResponseEntity<Object> vitesseParJ(@Valid @RequestBody RepeatingVariables pr) {
		Map<String, List<Integer>> m = passageInfo.vitesseParJ(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/vitesseParClasse")
	public ResponseEntity<Object> vitesseParClasse(@Valid @RequestBody ParClasseVariables pCv) {

		Map<String, Double> map = new HashMap<>();
		for (String classe : pCv.classes) {
			for (int v : pCv.voie) {
				List<Double> m = passageInfo.vitesseParClasse(pCv.resId, pCv.equipId, pCv.modeUtil, pCv.debutTime,
						pCv.finTime, classe, v);
				if (m.isEmpty()) {
					map.put(classe + "_" + v, 0.0);
				} else {
					map.put(classe + "_" + v, m.get(0));
				}
			}

		}
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant pour ces classe" + pCv.classes),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}

	}

	@PostMapping("/vitesseParRoute")
	public ResponseEntity<Object> vitesseParRoute(@Valid @RequestBody ParRouteVariables pr) {
		Map<String, Double> mapRoute = new HashMap<>();
		for (Long eId : pr.equipIds) {
			List<Double> pl = passageInfo.vitesseParRoute(pr.resId, pr.modeUtil, eId, pr.debutTime, pr.finTime, "VL");
			List<Double> vl = passageInfo.vitesseParRoute(pr.resId, pr.modeUtil, eId, pr.debutTime, pr.finTime, "PL");
			if (pl.isEmpty()) {
				mapRoute.put(eId.toString() + "_" + "Poids Lourd", 0.0);
			}
			if (vl.isEmpty()) {
				mapRoute.put(eId.toString() + "_" + "Vehicule Legers", 0.0);
			}
			if (!(pl.isEmpty())) {
				mapRoute.put(eId.toString() + "_" + "Poids Lourd", pl.get(0));
			}
			if (!(vl.isEmpty())) {
				mapRoute.put(eId.toString() + "_" + "Vehicule Legers", vl.get(0));
			}
		}
		if (mapRoute.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant dans ces routes durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapRoute, HttpStatus.OK);
		}
	}

	@PostMapping("/tempsReel")
	public ResponseEntity<Object> tempsReel(@Valid @RequestBody RepeatingVariables pr) {
		List<VolumeParResponseObject> m = passageInfo.tempReel(pr.resId, pr.equipId, pr.modeUtil, pr.voie);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@GetMapping("/{id}/equipements")
	public List<Long> allEquip(@Valid @PathVariable("id") Long i) {
		return equipRepo.equipParRes(i);
	}

	@GetMapping("/reseaux")
	public List<Long> allReseau() {
		return resRepo.allReseau();
	}

	@PostMapping("/aggressivite")
	public ResponseEntity<Object> aggre(@Valid @RequestBody RepeatingVariables pr) {
		Map<LocalDateTime, Double> map = passageInfo.aggre(pr.resId, pr.equipId, pr.debutTime, pr.finTime, pr.alpha);
		if (map.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/cam")
	public ResponseEntity<Object> cam(@Valid @RequestBody RepeatingVariables pr) {
		Double map = passageInfo.calculCam(pr.resId, pr.equipId, pr.debutTime, pr.finTime, pr.alpha);
		if (map == null) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/pourcentagePl")
	public ResponseEntity<Object> pourcPl(@Valid @RequestBody RepeatingVariables pr) {
		List<Double> map = passageInfo.pourcPl(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime, pr.finTime);
		if (map.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/tauxOccup")
	public ResponseEntity<Object> tauxOcc(@Valid @RequestBody RepeatingVariables pr) {
		Map<String, Double> map = passageInfo.tauxOc(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime, pr.finTime);
		if (map.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/tauxOccup1")
	public ResponseEntity<Object> tauxOcc2(@Valid @RequestBody RepeatingVariables pr) {
		List<Object> map = passageInfo.tauxOc2(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime, pr.finTime);
		if (map.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/ne")
	public ResponseEntity<Object> calculNe(@Valid @RequestBody RepeatingVariables pr) {
		Double ne = passageInfo.calculNe(pr.resId, pr.equipId, pr.debutTime, pr.finTime, pr.i, pr.n, pr.c, pr.yearD,
				pr.alpha);
		if (ne == 0) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(ne, HttpStatus.OK);
		}
	}

	@PostMapping("/surchargeH")
	public ResponseEntity<Object> surchargeH(@Valid @RequestBody RepeatingVariables pr) {
		List<Integer> ne = passageInfo.surchargeH(pr.resId, pr.equipId, pr.debutTime, pr.finTime);
		if (ne.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(ne, HttpStatus.OK);
		}
	}

	@PostMapping("/surchargeJ")
	public ResponseEntity<Object> surchargeJ(@Valid @RequestBody RepeatingVariables pr) {
		List<Integer> ne = passageInfo.surchargeJ(pr.resId, pr.equipId, pr.debutTime, pr.finTime);
		if (ne.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(ne, HttpStatus.OK);
		}
	}
	
	@GetMapping("/carte")
	public ResponseEntity<Object> carte(){
		List<CartographieHolder> res = passageInfo.getCarteInfo();
		if (res.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant dans cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
	}

}
