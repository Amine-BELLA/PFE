package com.production.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.production.demo.Exceptions.ResourceNotFoundException;
import com.production.demo.JsonHolder.ParClasseVariables;
import com.production.demo.JsonHolder.ParClasseVariablesTable;
import com.production.demo.JsonHolder.ParRouteVariables;
import com.production.demo.JsonHolder.ParSensVariables;
import com.production.demo.JsonHolder.ParVitesseVariables;
import com.production.demo.JsonHolder.ParVoieVariables;
import com.production.demo.JsonHolder.RepeatingVariables;
import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.JsonHolder.VolumeParResponseParRoute;
import com.production.demo.Service.PassageInfo;

@RestController
@CrossOrigin("*")
public class VolumeParAPIs {

	@Autowired
	private PassageInfo passageInfo;

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
				pCv.debutTime, pCv.finTime, pCv.typePoid, pCv.classes, pCv.sens);
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
		List<VolumeParResponseParRoute> m = passageInfo.volumeParRoute(pr.resId, pr.equipIds,pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParVoie")
	public ResponseEntity<Object> volumeParVoie(@Valid @RequestBody RepeatingVariables pr) {
		List<VolumeParResponseParRoute> m = passageInfo.volumeParVoie(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid, pr.voie);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/volumeParSens")
	public ResponseEntity<Object> volumeParSens(@Valid @RequestBody RepeatingVariables pr) {
		List<VolumeParResponseParRoute> m = passageInfo.volumeParSens(pr.resId, pr.equipId, pr.modeUtil, pr.debutTime,
				pr.finTime, pr.typePoid, pr.sens);
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
		Map<String,List<Object[]>> map = new HashMap<>();
		for(String classe:pCv.classes) {
		map.put(classe, passageInfo.grapheVolumeParClasse(pCv.resId, pCv.equipId, pCv.modeUtil, pCv.debutTime,
				pCv.finTime, pCv.typePoid, classe, pCv.sens));
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
		List<Object[]> m = passageInfo.grapheVolumeParVitesse(pVv.resId, pVv.equipId, pVv.modeUtil, pVv.debutTime,
				pVv.finTime, pVv.typePoid, pVv.sens);
		if (m.isEmpty()) {
			return new ResponseEntity<>(new ResourceNotFoundException("pas vehicule passant durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(m, HttpStatus.OK);
		}

	}

	@PostMapping("/grapheVolumeParRoute")
	public ResponseEntity<Object> grapheVolumeParRoute(@Valid @RequestBody ParRouteVariables pr) {
		Map<Long,List<Object[]>> map = new HashMap<>();
		for(Long eId:pr.equipIds) {
		map.put(eId,passageInfo.grapheVolumeParRoute(pr.resId, pr.modeUtil, eId, pr.debutTime, pr.finTime,
				pr.typePoid));
		};
		if (map.isEmpty()) {
			return new ResponseEntity<>(
					new ResourceNotFoundException("pas vehicule passant dans cette route durant cette période"),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(map, HttpStatus.OK);
		}
	}

	@PostMapping("/grapheVolumeParVoie")
	public ResponseEntity<Object> grapheVolumeParVoie(@Valid @RequestBody ParVoieVariables rV) {
		Map<Long,List<Object[]>> map = new HashMap<>();
		for(Long vId:rV.vIds) {
		map.put(vId,passageInfo.grapheVolumeParVoie(rV.resId, rV.modeUtil, rV.equipId, vId, rV.debutTime,
				rV.finTime, rV.typePoid));}
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
		Map<String,List<Object[]>> map = new HashMap<>();
		for(String sens:rV.sens) {
		map.put(sens,passageInfo.grapheVolumeParSens(rV.resId, rV.modeUtil, rV.equipId, sens, rV.debutTime,
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
}
