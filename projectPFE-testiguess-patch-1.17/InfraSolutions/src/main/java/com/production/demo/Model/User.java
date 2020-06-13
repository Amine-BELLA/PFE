package com.production.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "utilisateur")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Size(max = 30)
	@Column(nullable = false)
	private String prenom;

	@Size(max = 30)
	@Column(nullable = false)
	private String nom;

	@NaturalId
	@Email
	@Size(max = 200)
	@Column(nullable = false,unique = true)
	private String email;

	@Size(max = 100)
	@Column(nullable = false)
	private String direction;

	@Size(max = 100)
	@Column(nullable = false)
	private String service;

	@Column(nullable = false)
	private Long telephone;

	@Size(min = 8, max = 30)
	@Column(nullable = false)
//	@ColumnTransformer(
//			read = "decrypt( 'AES', '00', pswd  )",
//			write = "encrypt('AES', '00', ?)"
//		)
	private String password;

	// ManyToMany (Reseau)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserReseau> reseaux = new ArrayList<>();

	// ManyToOne(Role)
	//@ManyToOne(optional = false)
	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserReseau> getReseaux() {
		return reseaux;
	}

	public void setReseaux(List<UserReseau> reseaux) {
		this.reseaux = reseaux;
	}

	// Equal and HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	// Add and Remove Reseau
	public void addReseau(Reseau r) {
		UserReseau userReseau = new UserReseau(this, r);
		reseaux.add(userReseau);
		r.getUsers().add(userReseau);
	}

	

	public void removeReseau(Reseau r) {
		UserReseau userReseau = new UserReseau(this, r);
		r.getUsers().remove(userReseau);
		reseaux.remove(userReseau);
		userReseau.setUser(null);
		userReseau.setReseau(null);
	}

	
	
}
