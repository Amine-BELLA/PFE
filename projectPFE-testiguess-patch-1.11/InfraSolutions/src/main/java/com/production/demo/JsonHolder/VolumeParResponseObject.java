package com.production.demo.JsonHolder;

import java.time.LocalDate;
import java.time.LocalTime;

public class VolumeParResponseObject {
	private Long id;
	private int longueur;
	private int nombreEssieu;
	private LocalDate date;
	private LocalTime time;
	private int poids_total;
	private int gap;
	private String classe;
	private int vitesse;
	private int headway;
	private String surcharge;
	private int voie;
	private String sens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getNombreEssieu() {
		return nombreEssieu;
	}

	public void setNombreEssieu(int nombreEssieu) {
		this.nombreEssieu = nombreEssieu;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public int getPoids_total() {
		return poids_total;
	}

	public void setPoids_total(int poids_total) {
		this.poids_total = poids_total;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getHeadway() {
		return headway;
	}

	public void setHeadway(int headway) {
		this.headway = headway;
	}

	public String getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}

	public int getVoie() {
		return voie;
	}

	public void setVoie(int voie) {
		this.voie = voie;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public VolumeParResponseObject(Long id, int longueur, int nombreEssieu, LocalDate date, LocalTime time,
			String classe, int vitesse, int headway, String overloaded, int voie, String sens) {
		super();
		this.id = id;
		this.longueur = longueur;
		this.nombreEssieu = nombreEssieu;
		this.date = date;
		this.time = time;
		this.classe = classe;
		this.vitesse = vitesse;
		this.headway = headway;
		this.surcharge = overloaded;
		this.voie = voie;
		this.sens = sens;
	}

	public VolumeParResponseObject(int longueur, int nombreEssieu, LocalDate date, LocalTime time, String classe,
			int vitesse, int headway, String overloaded, int voie, String sens) {
		super();
		this.longueur = longueur;
		this.nombreEssieu = nombreEssieu;
		this.date = date;
		this.time = time;
		this.classe = classe;
		this.vitesse = vitesse;
		this.headway = headway;
		this.surcharge = overloaded;
		this.voie = voie;
		this.sens = sens;
	}

	
	 public VolumeParResponseObject(Long id, int longueur, int nombreEssieu, LocalDate date, LocalTime time,
			int poids_total, int gap, String classe, int vitesse, int headway, String surcharge, int voie,
			String sens) {
		super();
		this.id = id;
		this.longueur = longueur;
		this.nombreEssieu = nombreEssieu;
		this.date = date;
		this.time = time;
		this.poids_total = poids_total;
		this.gap = gap;
		this.classe = classe;
		this.vitesse = vitesse;
		this.headway = headway;
		this.surcharge = surcharge;
		this.voie = voie;
		this.sens = sens;
	}

}
