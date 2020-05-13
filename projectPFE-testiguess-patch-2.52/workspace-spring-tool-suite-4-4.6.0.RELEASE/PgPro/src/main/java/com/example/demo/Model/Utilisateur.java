package com.example.demo.Model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="utilisateur")
public class Utilisateur  {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column( nullable = false)
	private Long id;
	
	@Size(max=50)
	private String first_name;
	
	@Size(max=50)
	private String last_name;
	
	@NaturalId
	@Email
	@Size(max=50)
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date birth_date;
	
	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true )
	private List<Post> posts = new ArrayList<>();
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public Utilisateur(@Size(max = 50) String first_name, @Size(max = 50) String last_name,
			@Email @Size(max = 50) String email, Date birth_date) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.birth_date = birth_date;
	}
	public Utilisateur(){
		
	}
	
	
}
