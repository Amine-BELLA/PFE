package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class RepeatingVariables {

	public Long resId;
	public Long equipId;
	public String modeUtil;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public LocalDateTime debutTime;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public LocalDateTime finTime;
	public String typePoid;
	public int[] voie;
	public String sens;
	public int speed1;
	public int speed2;
	public int long1;
	public int long2;

	public int[] getVoie() {
		return voie;
	}

	public void setVoie(int[] voie) {
		this.voie = voie;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public int getSpeed1() {
		return speed1;
	}

	public void setSpeed1(int speed1) {
		this.speed1 = speed1;
	}

	public int getSpeed2() {
		return speed2;
	}

	public void setSpeed2(int speed2) {
		this.speed2 = speed2;
	}

	public int getLong1() {
		return long1;
	}

	public void setLong1(int long1) {
		this.long1 = long1;
	}

	public int getLong2() {
		return long2;
	}

	public void setLong2(int long2) {
		this.long2 = long2;
	}

	public RepeatingVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid, int[] voie) {
		super();
		this.resId = resId;
		this.equipId = equipId;
		this.modeUtil = modeUtil;
		this.debutTime = debutTime;
		this.finTime = finTime;
		this.typePoid = typePoid;
		this.voie = voie;
	}

	public RepeatingVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid) {
		super();
		this.resId = resId;
		this.equipId = equipId;
		this.modeUtil = modeUtil;
		this.debutTime = debutTime;
		this.finTime = finTime;
		this.typePoid = typePoid;
	}

	public RepeatingVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			String typePoid, String sens) {
		super();
		this.resId = resId;
		this.equipId = equipId;
		this.modeUtil = modeUtil;
		this.debutTime = debutTime;
		this.finTime = finTime;
		this.typePoid = typePoid;
		this.sens = sens;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public Long getEquipId() {
		return equipId;
	}

	public void setEquipId(Long equipId) {
		this.equipId = equipId;
	}

	public String getModeUtil() {
		return modeUtil;
	}

	public void setModeUtil(String modeUtil) {
		this.modeUtil = modeUtil;
	}

	public LocalDateTime getDebutTime() {
		return debutTime;
	}

	public void setDebutTime(LocalDateTime debutTime) {
		this.debutTime = debutTime;
	}

	public LocalDateTime getFinTime() {
		return finTime;
	}

	public void setFinTime(LocalDateTime finTime) {
		this.finTime = finTime;
	}

	public String getTypePoid() {
		return typePoid;
	}

	public void setTypePoid(String typePoid) {
		this.typePoid = typePoid;
	}

	public RepeatingVariables() {
		super();
	}

	public RepeatingVariables(Long resId, Long equipId, String modeUtil, LocalDateTime debutTime, LocalDateTime finTime,
			int speed1, int speed2, int long1, int long2) {
		super();
		this.resId = resId;
		this.equipId = equipId;
		this.modeUtil = modeUtil;
		this.debutTime = debutTime;
		this.finTime = finTime;
		this.speed1 = speed1;
		this.speed2 = speed2;
		this.long1 = long1;
		this.long2 = long2;
	}

}
