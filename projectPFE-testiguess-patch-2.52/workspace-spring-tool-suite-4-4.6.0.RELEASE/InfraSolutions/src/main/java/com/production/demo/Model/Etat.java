package com.production.demo.Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Etat {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Size(max = 100)
	@Column(name = "etat_eonnectivite")
	private String etaCon;

	@Size(max = 100)
	@Column(name = "etat_memoire")
	private String memoire;

	private int batterie;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "temps_mesure")
	private Timestamp tempMesure;
	// ManyToOne(Equipement)
	@ManyToOne
	private Equipement equip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtaCon() {
		return etaCon;
	}

	public void setEtaCon(String etaCon) {
		this.etaCon = etaCon;
	}

	public String getMemoire() {
		return memoire;
	}

	public void setMemoire(String memoire) {
		this.memoire = memoire;
	}

	public int getBatterie() {
		return batterie;
	}

	public void setBatterie(int batterie) {
		this.batterie = batterie;
	}

	public Timestamp getTempMesure() {
		return tempMesure;
	}

	public void setTempMesure(Timestamp tempMesure) {
		this.tempMesure = tempMesure;
	}

	public Etat() {
		super();
	}

	public Equipement getEquip() {
		return equip;
	}

	public void setEquip(Equipement equip) {
		this.equip = equip;
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batterie;
		result = prime * result + ((etaCon == null) ? 0 : etaCon.hashCode());
		result = prime * result + ((memoire == null) ? 0 : memoire.hashCode());
		result = prime * result + ((tempMesure == null) ? 0 : tempMesure.hashCode());
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
		Etat other = (Etat) obj;
		if (batterie != other.batterie)
			return false;
		if (etaCon == null) {
			if (other.etaCon != null)
				return false;
		} else if (!etaCon.equals(other.etaCon))
			return false;
		if (memoire == null) {
			if (other.memoire != null)
				return false;
		} else if (!memoire.equals(other.memoire))
			return false;
		if (tempMesure == null) {
			if (other.tempMesure != null)
				return false;
		} else if (!tempMesure.equals(other.tempMesure))
			return false;
		return true;
	}

}
