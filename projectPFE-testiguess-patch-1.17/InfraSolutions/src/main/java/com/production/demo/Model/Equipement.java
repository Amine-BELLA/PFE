package com.production.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NaturalId
	@Column(name = "site_number", nullable = false)
	private Double siteNumero;

	@NaturalId
	@Column(name = "serial_num", nullable = false)
	private Long serNum;

	@Size(max = 100)
	@Column(nullable = false)
	private String model;

	@NaturalId
	@Size(max = 100)
	@Column(name = "Num_Serie", nullable = false)
	private String numSerie;

	@Column(nullable = false)
	private String mode;

	@NaturalId
	@Size(max = 100)
	@Column(nullable = false)
	private String fournisseur;

	@NotBlank
	@Column(name = "lat", nullable = false)
	@Size(max = 100)
	private String lat;

	@NotBlank
	@Column(name = "lng", nullable = false)
	@Size(max = 100)
	private String lng;

	@NotBlank
	@Column(name = "CoordonneePK", nullable = false)
	@Size(max = 100)
	private String coorPK;

	// ManyToOne(Reseau)
	@ManyToOne(optional = false)
	private Reseau reseau;

	public List<Passage> getPassages() {
		return passages;
	}

	public void setPassages(List<Passage> passages) {
		this.passages = passages;
	}

	// OneToMany(Etat)
	@OneToMany(mappedBy = "equip", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Etat> etats = new ArrayList<>();

	// OneToMany(Passage)
	@OneToMany(mappedBy = "equip", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Passage> passages = new ArrayList<>();

	public List<Etat> getEtats() {
		return etats;
	}

	public void setEtats(List<Etat> etats) {
		this.etats = etats;
	}

	public Reseau getReseau() {
		return reseau;
	}

	public void setReseau(Reseau reseau) {
		this.reseau = reseau;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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

	public String getCoorPK() {
		return coorPK;
	}

	public void setCoorPK(String coorPK) {
		this.coorPK = coorPK;
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

	public Equipement() {
		super();
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coorPK == null) ? 0 : coorPK.hashCode());
		result = prime * result + ((fournisseur == null) ? 0 : fournisseur.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((numSerie == null) ? 0 : numSerie.hashCode());
		result = prime * result + ((siteNumero == null) ? 0 : siteNumero.hashCode());
		result = prime * result + ((serNum == null) ? 0 : serNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipement other = (Equipement) obj;
		if (coorPK == null) {
			if (other.coorPK != null)
				return false;
		} else if (!coorPK.equals(other.coorPK))
			return false;
		if (fournisseur == null) {
			if (other.fournisseur != null)
				return false;
		} else if (!fournisseur.equals(other.fournisseur))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lng == null) {
			if (other.lng != null)
				return false;
		} else if (!lng.equals(other.lng))
			return false;
		if (mode == null) {
			if (other.mode != null)
				return false;
		} else if (!mode.equals(other.mode))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (numSerie == null) {
			if (other.numSerie != null)
				return false;
		} else if (!numSerie.equals(other.numSerie))
			return false;
		if (siteNumero == null) {
			if (other.siteNumero != null)
				return false;
		} else if (!siteNumero.equals(other.siteNumero))
			return false;
		if (serNum == null) {
			if (other.serNum != null)
				return false;
		} else if (!serNum.equals(other.serNum))
			return false;
		return true;
	}

	// Add and Remove a Passage
	public void addPassage(Passage p) {
		passages.add(p);
		p.setEquip(this);
	}

	public void removePassage(Passage p) {
		passages.remove(p);
		p.setEquip(null);
	}

	// Add and Remove a Etat
	public void addEtat(Etat e) {
		etats.add(e);
		e.setEquip(this);
	}

	public void removeEtat(Etat e) {
		etats.remove(e);
		e.setEquip(null);
	}

}
