package com.production.demo.JsonHolder;

public class EquipJSONHolder {

	private String mode;
	private String numSerie;
	private String fournisseur;
	private String model;
	private String lat;
	private String lng;
	private String coordonnPK;
	private Double siteNumero;
	private Long serNum;
	private Long resId;

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCoordonnPK() {
		return coordonnPK;
	}

	public void setCoordonnPK(String coordonnPK) {
		this.coordonnPK = coordonnPK;
	}

	public Double getSiteNumero() {
		return siteNumero;
	}

	public void setSiteNumero(Double siteNumero) {
		this.siteNumero = siteNumero;
	}

	public Long getSerNum() {
		return serNum;
	}

	public void setSerNum(Long serNum) {
		this.serNum = serNum;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public EquipJSONHolder(String mode, String numSerie, String fournisseur, String model, String lat, String lng,
			String coordonnPK, Double siteNumero, Long serNum, Long resId) {
		super();
		this.mode = mode;
		this.numSerie = numSerie;
		this.fournisseur = fournisseur;
		this.model = model;
		this.lat = lat;
		this.lng = lng;
		this.coordonnPK = coordonnPK;
		this.siteNumero = siteNumero;
		this.serNum = serNum;
		this.resId = resId;
	}

	public EquipJSONHolder() {
		super();
	}

}