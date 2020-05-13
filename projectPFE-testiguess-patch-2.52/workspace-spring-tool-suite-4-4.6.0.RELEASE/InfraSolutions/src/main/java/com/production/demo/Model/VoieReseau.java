package com.production.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VoieReseau {

	@Id
	@ManyToOne
	private Voie voie;

	@Id
	@ManyToOne
	private Reseau reseau;

	public VoieReseau(Voie voie, Reseau reseau) {
		super();
		this.voie = voie;
		this.reseau = reseau;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	public Reseau getReseau() {
		return reseau;
	}

	public void setReseau(Reseau reseau) {
		this.reseau = reseau;
	}

}
