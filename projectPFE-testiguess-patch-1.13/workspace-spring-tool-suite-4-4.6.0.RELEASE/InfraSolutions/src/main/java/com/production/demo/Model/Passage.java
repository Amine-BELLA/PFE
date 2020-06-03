package com.production.demo.Model;

import java.sql.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Passage {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	@Size(max = 50)
	@Column(name = "classe_vehicule")
	private String classe;

	private Long headway;

	private int gap;

	private int gross;

	@Column(name = "speed_Kmh")
	private int speed;

	// ManyToOne (Equipement)
	@ManyToOne
	private Equipement equip;

	// ManyToOne(Vehicule)
	private Vehicule vehicule;

	// OneToMany(Axe)
	@OneToMany(mappedBy = "passage", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Axes> axes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Long getHeadway() {
		return headway;
	}

	public void setHeadway(Long headway) {
		this.headway = headway;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public int getGross() {
		return gross;
	}

	public void setGross(int gross) {
		this.gross = gross;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Equipement getEquip() {
		return equip;
	}

	public void setEquip(Equipement equip) {
		this.equip = equip;
	}

	public List<Axes> getAxes() {
		return axes;
	}

	public void setAxes(List<Axes> axes) {
		this.axes = axes;
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((equip == null) ? 0 : equip.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Passage other = (Passage) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (equip == null) {
			if (other.equip != null)
				return false;
		} else if (!equip.equals(other.equip))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	// Add and Remove a Axe
	public void addAxe(Axes a) {
		axes.add(a);
		a.setPassage(this);
	}

	public void removeAxe(Axes a) {
		axes.remove(a);
		a.setPassage(null);
	}

}
