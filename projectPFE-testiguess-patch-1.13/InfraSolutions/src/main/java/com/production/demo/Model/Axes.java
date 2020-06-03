package com.production.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "axe")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Axes {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "axe_weight",nullable = false)
	private int axeWt;
	
	@Column(name = "axe_type",nullable = false)
	private String type;

	// ManyToOne(Vehicule)
	@ManyToOne
	private Vehicule vehicule;

	// ManyToOne(Passage)
	@ManyToOne
	private Passage passage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAxeWt() {
		return axeWt;
	}

	public void setAxeWt(int axeWt) {
		this.axeWt = axeWt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Passage getPassage() {
		return passage;
	}

	public void setPassage(Passage passage) {
		this.passage = passage;
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + axeWt;
		result = prime * result + type.hashCode() ;
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
		Axes other = (Axes) obj;
		if (axeWt != other.axeWt)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public Axes() {
		super();
	}
	
	

}
