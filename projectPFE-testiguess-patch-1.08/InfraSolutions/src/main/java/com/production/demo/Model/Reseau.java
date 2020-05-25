package com.production.demo.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reseau {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NaturalId
	@Column(nullable = false)
	private String resId;

	@NaturalId
	@Column(name = "reseau_num", nullable = false)
	private Double numero;

	@NaturalId
	@Column(name = "reseau_serial_num", nullable = false)
	private Long serNum;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false)
	private String route;

	@NotBlank
	@Column(name = "CoordonneeGPS", nullable = false)
	@Size(max = 100)
	private String coorGPS;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false)
	private String region;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false)
	private String province;

	@NotBlank
	@Column(name = "number_voie", nullable = false)
	private int numVoie;

	// ManyToMany(User)
	@OneToMany(mappedBy = "reseau", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserReseau> users = new HashSet<>();

	// OneToMany(Equipement)
	@OneToMany(mappedBy = "reseau", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Equipement> equips = new HashSet<>();

	// OneToMany(Voie)
	@OneToMany(mappedBy = "reseau", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Voie> voies = new ArrayList<>();

	public List<Voie> getVoies() {
		return voies;
	}

	public void setVoies(List<Voie> voies) {
		this.voies = voies;
	}

	public Set<Equipement> getEquips() {
		return equips;
	}

	public void setEquips(Set<Equipement> equips) {
		this.equips = equips;
	}

	public Reseau() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNumero() {
		return numero;
	}

	public void setNumero(Double numero) {
		this.numero = numero;
	}

	public Long getSerNum() {
		return serNum;
	}

	public void setSerNum(Long serNum) {
		this.serNum = serNum;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getCoorGPS() {
		return coorGPS;
	}

	public void setCoorGPS(String coorGPS) {
		this.coorGPS = coorGPS;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getNumVoie() {
		return numVoie;
	}

	public void setNumVoie(int numVoie) {
		this.numVoie = numVoie;
	}

	public String getResId() {
		return resId;
	}

	public void setResId(String resId) {
		this.resId = resId;
	}

	public Set<UserReseau> getUsers() {
		return users;
	}

	public void setUsers(Set<UserReseau> users) {
		this.users = users;
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coorGPS == null) ? 0 : coorGPS.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((resId == null) ? 0 : resId.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
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
		Reseau other = (Reseau) obj;
		if (coorGPS == null) {
			if (other.coorGPS != null)
				return false;
		} else if (!coorGPS.equals(other.coorGPS))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (resId == null) {
			if (other.resId != null)
				return false;
		} else if (!resId.equals(other.resId))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		if (serNum == null) {
			if (other.serNum != null)
				return false;
		} else if (!serNum.equals(other.serNum))
			return false;
		return true;
	}

	// Add and Remove Equipement
	public void addEquip(Equipement e) {
		equips.add(e);
		e.setReseau(this);
	}

	public void removeEquip(Equipement e) {
		equips.remove(e);
		e.setReseau(null);
	}

	// Add and Remove Voies
	public void addVoie(Voie v) {
		voies.add(v);
		v.setReseau(this);
	}

	public void removeVoie(Voie v) {
		voies.remove(v);
		v.setReseau(null);
	}
}
