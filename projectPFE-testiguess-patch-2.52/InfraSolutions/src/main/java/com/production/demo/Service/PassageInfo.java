package com.production.demo.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.demo.Model.Passage;
import com.production.demo.Repository.PassageRepo;

@Service
public class PassageInfo {

	@Autowired
	private PassageRepo passageRepo;
	
	public List<Object[]> volumeParPeriode(Long rId,Long eId,String mode,LocalDateTime debutTime,LocalDateTime finTime,String typeP){
		Optional<List<Object[]>> m = passageRepo.findVolumeByPeriode(rId,eId, mode, debutTime, finTime, typeP);
		return m.orElse(new ArrayList<Object[]>());
		
	}
	public List<Passage> getPassages(){
		return passageRepo.findAll();
	}
		
	
	
}
