package com.production.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Voie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private Long numero;

	@Size(max = 100)
	private String sens;

	// ManyToMany (Reseau)
	@OneToMany(mappedBy = "voie", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VoieReseau> reseaux = new ArrayList<>();

	public List<VoieReseau> getReseaux() {
		return reseaux;
	}

	public void setReseaux(List<VoieReseau> reseaux) {
		this.reseaux = reseaux;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public Voie() {
		super();
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((sens == null) ? 0 : sens.hashCode());
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
		Voie other = (Voie) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (sens == null) {
			if (other.sens != null)
				return false;
		} else if (!sens.equals(other.sens))
			return false;
		return true;
	}

	// Add and Remove Reseau
	public void addReseau(Reseau r) {
		VoieReseau voieReseau = new VoieReseau(this, r);
		reseaux.add(voieReseau);
		r.getVoies().add(voieReseau);
	}

	public void removeReseau(Reseau r) {
		VoieReseau voieReseau = new VoieReseau(this, r);
		r.getVoies().remove(voieReseau);
		reseaux.remove(voieReseau);
		voieReseau.setVoie(null);
		voieReseau.setReseau(null);
	}

}
