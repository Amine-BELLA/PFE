package com.production.demo.JsonHolder;

public class UserJSONHolder {
	
	private String prenom;
	private String nom;
	private String email;
	private String direction;
	private String service;
	private Long telephone;
	private String password;
	private String role;
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Long getTelephone() {
		return telephone;
	}
	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserJSONHolder(String prenom, String nom, String email, String direction, String service, Long telephone,
			String password, String role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.direction = direction;
		this.service = service;
		this.telephone = telephone;
		this.password = password;
		this.role = role;
	}
	public UserJSONHolder() {
		super();
	}
	
}
