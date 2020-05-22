package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

public class ParClasseVariables extends RepeatingVariables {
	public String[] classes;
	public String sens;

	public String[] getClasses() {
		return classes;
	}

	public void setClasses(String[] classes) {
		this.classes = classes;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public ParClasseVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid, int[] voie, String[] classes, String sens) {
		super(resId, equipId, modeUtil, debutTime, finTime, typePoid, voie);
		this.classes = classes;
		this.sens = sens;
	}

	public ParClasseVariables() {
		super();
	}

	

}
