package com.production.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.production.demo.Exceptions.ResourceNotFoundException;
import com.production.demo.JsonHolder.RepeatingVariables;
import com.production.demo.Model.Passage;
import com.production.demo.Service.PassageInfo;

@RestController
@CrossOrigin("*")
public class VolumeParAPIs {
	
	@Autowired
	private PassageInfo passageInfo;
	
	@PostMapping("/volumeParRoute")
	public List<Object[]> volumeParRoute(@Valid @RequestBody RepeatingVariables pr){
		List<Object[]> m = passageInfo.volumeParPeriode(pr.resId, pr.equipId, pr.modeUtil,pr.debutTime,pr.finTime , pr.typePoid);
	
			return m;
		}

	@GetMapping("/passage")
	public List<Passage> getPassage(){
		return passageInfo.getPassages();
	}
}
