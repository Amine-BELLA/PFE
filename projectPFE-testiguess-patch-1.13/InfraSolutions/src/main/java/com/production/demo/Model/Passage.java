package com.production.demo.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Passage {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	private LocalDate date;

	@Column(nullable = false)
	private LocalTime time;

	@Column(nullable = false)
	private LocalDateTime timestamp;

	@Size(max = 50)
	@Column(name = "classe_vehicule")
	private String classe;

	@Column(nullable = false)
	private int headway;

	@Column(nullable = false)
	private String overloaded;

	@Column(nullable = false)
	private int gap;

	@Column(nullable = false)
	private int timeGap;

	private int gross;

	@NotBlank
	@Column(name = "type_poids", nullable = false)
	private String typePoid;

	@Column(name = "speed_Kmh", nullable = false)
	private int speed;

	// ManyToOne (Equipement)
	@ManyToOne(optional = false)
	private Equipement equip;

	// ManyToOne(Vehicule)
	@ManyToOne(optional = false)
	private Vehicule vehicule;

	// ManyToOne(Voie)
	@ManyToOne(optional = false)
	private Voie voie;

	// OneToMany(Axe)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Axes> axes = new ArrayList<>();

	public Passage() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getHeadway() {
		return headway;
	}

	public void setHeadway(int headway) {
		this.headway = headway;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public int getTimeGap() {
		return timeGap;
	}

	public void setTimeGap(int timeGap) {
		this.timeGap = timeGap;
	}

	public int getGross() {
		return gross;
	}

	public void setGross(int gross) {
		this.gross = gross;
	}

	public String getTypePoid() {
		return typePoid;
	}

	public void setTypePoid(@NotBlank String typePoid) {
		this.typePoid = typePoid;
	}

	public String getOverloaded() {
		return overloaded;
	}

	public void setOverloaded(String overloaded) {
		this.overloaded = overloaded;
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

	public Vehicule getVehicule() {
		return vehicule;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp() {
		this.timestamp = time.atDate(date);
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
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

	public Passage(LocalDate date, LocalTime time, @Size(max = 50) String classe, int headway, String overloaded,
			int gap, int gross, @NotBlank String typePoid, int speed) {
		super();
		this.date = date;
		this.time = time;
		this.classe = classe;
		this.headway = headway;
		this.overloaded = overloaded;
		this.gap = gap;
		this.gross = gross;
		this.typePoid = typePoid;
		this.speed = speed;
	}

}
