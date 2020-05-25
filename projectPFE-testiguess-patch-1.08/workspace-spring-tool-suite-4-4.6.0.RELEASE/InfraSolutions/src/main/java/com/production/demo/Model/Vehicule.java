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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

@Entity
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	private Long longueur;

	@NotBlank
	@Column(name = "type_poids")
	private boolean typePoid;

	@URL
	private URL silouhette;

	private int numEssieu;

	// OneToMany(D_essieu)
	@OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<DisE> distEssieux = new ArrayList<>();

	// OneToMany(Passage)
	@OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Passage> passages = new ArrayList<>();

	// OneToMany(Axe)
	@OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Axes> axes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLongueur() {
		return longueur;
	}

	public void setLongueur(Long longueur) {
		this.longueur = longueur;
	}

	public boolean isTypePoid() {
		return typePoid;
	}

	public void setTypePoid(boolean typePoid) {
		this.typePoid = typePoid;
	}

	public URL getSilouhette() {
		return silouhette;
	}

	public void setSilouhette(URL silouhette) {
		this.silouhette = silouhette;
	}

	public int getNumEssieu() {
		return numEssieu;
	}

	public void setNumEssieu(int numEssieu) {
		this.numEssieu = numEssieu;
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((longueur == null) ? 0 : longueur.hashCode());
		result = prime * result + numEssieu;
		result = prime * result + (typePoid ? 1231 : 1237);
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
		Vehicule other = (Vehicule) obj;
		if (longueur == null) {
			if (other.longueur != null)
				return false;
		} else if (!longueur.equals(other.longueur))
			return false;
		if (numEssieu != other.numEssieu)
			return false;
		if (typePoid != other.typePoid)
			return false;
		return true;
	}

	// Add and Remove a Passage
	public void addPassage(Passage p) {
		passages.add(p);
		p.setVehicule(this);
	}

	public void removePassage(Passage p) {
		passages.remove(p);
		p.setVehicule(null);
	}

	// Add and Remove a Distance_Essieu
	public void addDe(DisE d) {
		distEssieux.add(d);
		d.setVehicule(this);
	}

	public void removeDe(DisE d) {
		distEssieux.remove(d);
		d.setVehicule(null);
	}

	// Add and Remove a Axe
	public void addAxe(Axes a) {
		axes.add(a);
		a.setVehicule(this);
	}

	public void removeAxe(Axes a) {
		axes.remove(a);
		a.setVehicule(null);
	}

}
