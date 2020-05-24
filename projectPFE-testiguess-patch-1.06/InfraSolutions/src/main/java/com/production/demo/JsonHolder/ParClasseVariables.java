package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

public class ParClasseVariables extends RepeatingVariables {
	public String[] classes;

	public String[] getClasses() {
		return classes;
	}

	public void setClasses(String[] classes) {
		this.classes = classes;
	}


	public ParClasseVariables() {
		super();
	}

	public ParClasseVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid, int[] voie, String[] classes) {
		super(resId, equipId, modeUtil, debutTime, finTime, typePoid, voie);
		this.classes = classes;
		
	}

	

}
