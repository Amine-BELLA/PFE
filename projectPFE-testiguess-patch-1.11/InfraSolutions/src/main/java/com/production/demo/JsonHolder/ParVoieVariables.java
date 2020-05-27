package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

public class ParVoieVariables extends RepeatingVariables {
	public int[] vNums;

	public int[] getvNums() {
		return vNums;
	}

	public void setvNums(int[] vNums) {
		this.vNums = vNums;
	}

	public ParVoieVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid, int[] voie, int[] vNums) {
		super(resId, equipId, modeUtil, debutTime, finTime, typePoid, voie);
		this.vNums = vNums;
	}

	public ParVoieVariables() {
		super();
	}

	

}
