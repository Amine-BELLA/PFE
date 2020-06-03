package com.production.demo.JsonHolder;

public class CartographieHolder {
	private String coordonneePK;
	private String lat;
	private String lng;
	private String model;
	private String mode;
	private String route;
	private String province;
	private String numeroSerie;
	private String region;

	public String getCoordonneePK() {
		return coordonneePK;
	}

	public void setCoordonneePK(String coordonneePK) {
		this.coordonneePK = coordonneePK;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numSerie) {
		this.numeroSerie = numSerie;
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

	public void setLng(String alt) {
		this.lng = alt;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public CartographieHolder(String coordonneePK, String lat, String lng, String model, String mode, String route,
			String province, String numeroSerie, String region) {
		super();
		this.coordonneePK = coordonneePK;
		this.lat = lat;
		this.lng = lng;
		this.model = model;
		this.mode = mode;
		this.route = route;
		this.province = province;
		this.numeroSerie = numeroSerie;
		this.region=region;
	}

}
