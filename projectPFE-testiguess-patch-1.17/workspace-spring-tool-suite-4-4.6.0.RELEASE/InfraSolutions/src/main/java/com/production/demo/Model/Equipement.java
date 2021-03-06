package com.production.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.production.demo.Enums.ModeUtilisation;

@Entity
public class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Size(max = 100)
	private String model;

	@Size(max = 100)
	@Column(name = "Num_Serie")
	private String numSerie;

	@Enumerated(EnumType.STRING)
	private ModeUtilisation mode;

	@Size(max = 100)
	private String fournisseur;

	// ManyToOne(Reseau)
	@ManyToOne
	private Reseau reseau;

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

	public ModeUtilisation getMode() {
		return mode;
	}

	public void setMode(ModeUtilisation mode) {
		this.mode = mode;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Equipement() {
		super();
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fournisseur == null) ? 0 : fournisseur.hashCode());
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((numSerie == null) ? 0 : numSerie.hashCode());
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
		if (fournisseur == null) {
			if (other.fournisseur != null)
				return false;
		} else if (!fournisseur.equals(other.fournisseur))
			return false;
		if (mode != other.mode)
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
