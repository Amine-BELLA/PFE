package com.production.demo.Enums;

public enum Roleuser {

	Utilisateur("U"), Administrateur("ADMIN");

	private final String code;

	Roleuser(String code) {
		this.code = code;
	}

	public static Roleuser fromCode(String code) {
		if (code == "U" || code == "u") {
			return Utilisateur;
		}
		if (code == "ADMIN" || code == "admin") {
			return Administrateur;
		} else {
			return null;
		}
	}

	public String getCode() {
		return code;
	}

}
