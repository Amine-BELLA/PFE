package com.production.demo.JsonHolder;

import java.time.LocalDate;
import java.time.LocalTime;

public class VolumeParResponseParRoute extends VolumeParResponseObject {
	public Long equipementId;

	public VolumeParResponseParRoute(Long equipementId, Long id, int longueur, int nombreEssieu, LocalDate date, LocalTime time,
			String classe, int vitesse, int headway, String overloaded, int voie, String sens) {
		super(id, longueur, nombreEssieu, date, time, classe, vitesse, headway, overloaded, voie, sens);
		this.equipementId = equipementId;
	}

	public Long getEquipementId() {
		return equipementId;
	}

	public void setEquipementId(Long equipementId) {
		this.equipementId = equipementId;
	}
	
	

}
