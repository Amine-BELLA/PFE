package com.production.demo.JsonHolder;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class ParRouteVariables {
	public Long resId;
	public String modeUtil;
	public Long[] equipIds;
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

	public String getModeUtil() {
		return modeUtil;
	}

	public void setModeUtil(String modeUtil) {
		this.modeUtil = modeUtil;
	}

	public Long[] getEquipIds() {
		return equipIds;
	}

	public void setEquipIds(Long[] equipIds) {
		this.equipIds = equipIds;
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

	public ParRouteVariables(Long resId, String modeUtil, Long[] equipIds, LocalDateTime debutTime,
			LocalDateTime finTime, String typePoid) {
		super();
		this.resId = resId;
		this.modeUtil = modeUtil;
		this.equipIds = equipIds;
		this.debutTime = debutTime;
		this.finTime = finTime;
		this.typePoid = typePoid;
	}

	public ParRouteVariables() {
		super();
	}

}
