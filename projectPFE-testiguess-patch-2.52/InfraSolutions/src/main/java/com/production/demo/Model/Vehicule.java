package com.production.demo.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	private int longueur;

	@Column(nullable = true)
	private String silouhette;

	@Column(nullable = true)
	private int numEssieu;

	// OneToMany(D_essieu)
	@OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<DisE> distEssieux = new ArrayList<>();

	// OneToMany(Passage)
	@OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Passage> passages = new HashSet<>();

	// OneToMany(Axe)
	@OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Axes> axes = new HashSet<>();

	public List<DisE> getDistEssieux() {
		return distEssieux;
	}

	public void setDistEssieux(List<DisE> distEssieux) {
		this.distEssieux = distEssieux;
	}

	public Set<Passage> getPassages() {
		return passages;
	}

	public void setPassages(Set<Passage> passages) {
		this.passages = passages;
	}

	public Set<Axes> getAxes() {
		return axes;
	}

	public void setAxes(Set<Axes> axes) {
		this.axes = axes;
	}

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

	public String getSilouhette() {
		return silouhette;
	}

	public void setSilouhette(String silouhette) {
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
		result = prime * result + numEssieu;
		result = prime * result + ((passages == null) ? 0 : passages.hashCode());
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
		if (numEssieu != other.numEssieu)
			return false;
		if (passages == null) {
			if (other.passages != null)
				return false;
		} else if (!passages.equals(other.passages))
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
	

	public Vehicule() {
		super();
	}

	public Vehicule(@NotBlank int longueur, String silouhette, int numEssieu) {
		super();
		this.longueur = longueur;
		this.silouhette = silouhette;
		this.numEssieu = numEssieu;
	}
	

}
