package com.production.demo.Enums;

public enum TypePoids {
	PoidsLourd("PL"), VehiculeLeger("VL");

	private final String code;

	TypePoids(String i) {
		this.code = i;
	}

	public static TypePoids fromCode(String code) {
		if(code=="PL" || code=="pl" ) {
			return PoidsLourd;
		}if(code=="VL" || code=="vl" ) {
			return VehiculeLeger;
		}
		else {
			return null;
		}
	}

	public String getCode() {
		return code;
	}
}
