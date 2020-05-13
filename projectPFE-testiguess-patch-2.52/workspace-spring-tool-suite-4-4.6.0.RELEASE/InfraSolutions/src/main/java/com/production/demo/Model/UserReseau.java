package com.production.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserReseau {
	
	@Id
	@ManyToOne
	private User user;
	
	@Id
	@ManyToOne
	private Reseau reseau;
	
	public UserReseau(User user, Reseau reseau) {
		super();
		this.user = user;
		this.reseau = reseau;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reseau getReseau() {
		return reseau;
	}

	public void setReseau(Reseau reseau) {
		this.reseau = reseau;
	}
}
