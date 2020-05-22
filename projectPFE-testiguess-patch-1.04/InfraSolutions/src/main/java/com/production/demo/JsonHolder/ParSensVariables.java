package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

public class ParSensVariables extends RepeatingVariables {
	public String[] sens;

	public String[] getSens() {
		return sens;
	}

	public void setSens(String[] sens) {
		this.sens = sens;
	}

	public ParSensVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid, int[] voie, String[] sens) {
		super(resId, equipId, modeUtil, debutTime, finTime, typePoid, voie);
		this.sens = sens;
	}

	public ParSensVariables() {
		super();
	}

}
