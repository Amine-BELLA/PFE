package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

public class ParVoieVariables extends RepeatingVariables {
	public Long[] vIds;

	public ParVoieVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid, int[] voie, Long[] vIds) {
		super(resId, equipId, modeUtil, debutTime, finTime, typePoid, voie);
		this.vIds = vIds;
	}

	public Long[] getvIds() {
		return vIds;
	}

	public void setvIds(Long[] vIds) {
		this.vIds = vIds;
	}

	public ParVoieVariables() {
		super();
	}

}
