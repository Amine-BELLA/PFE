package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

public class ParSensVariables extends RepeatingVariables {
	public String[] sense;

	public String[] getSense() {
		return sense;
	}

	public void setSense(String[] sens) {
		this.sense = sens;
	}

	public ParSensVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid, int[] voie, String[] sens) {
		super(resId, equipId, modeUtil, debutTime, finTime, typePoid, voie);
		this.sense = sens;
	}

	public ParSensVariables() {
		super();
	}

}
