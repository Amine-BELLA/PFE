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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Reseau {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false)
	private String route;

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

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		result = prime * result + ((voies == null) ? 0 : voies.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		if (voies == null) {
			if (other.voies != null)
				return false;
		} else if (!voies.equals(other.voies))
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
	
	// Add and Remove Reseau
	public void addUser(User u) {
		UserReseau userReseau = new UserReseau(u, this);
		users.add(userReseau);
		u.getReseaux().add(userReseau);
	}

	

	public void removeUser(User u) {
		UserReseau userReseau = new UserReseau(u, this);
		u.getReseaux().remove(userReseau);
		users.remove(userReseau);
		userReseau.setUser(null);
		userReseau.setReseau(null);
	}

}
