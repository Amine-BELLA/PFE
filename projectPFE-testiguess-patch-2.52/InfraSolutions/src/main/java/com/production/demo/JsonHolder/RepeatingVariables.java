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
	
	
}