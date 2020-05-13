package com.production.demo.Enums;

public enum RoleEnum {

	Utilisateur("U"), Administrateur("ADMIN");

	private final String code;

	RoleEnum(String code) {
		this.code=code;
	}
	public static RoleEnum fromCode(String code) {
		if(code=="U" || code=="u" ) {
			return Utilisateur;
		}if(code=="ADMIN" || code=="admin" ) {
			return Administrateur;
		}
		else {
			return null;
		}
	}

	public String getCode() {
		return code;
	}

}
