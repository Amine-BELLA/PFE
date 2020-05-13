package com.production.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.production.demo.Enums.RoleEnum;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Enumerated(EnumType.STRING)
	private RoleEnum roleName;
	// OneToMany(User)
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> rUsers = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public Role() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleEnum getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleEnum roleName) {
		this.roleName = roleName;
	}

	public void addUser(User u) {
		rUsers.add(u);
		u.setRole(this);
	}

	public void removeUser(User u) {
		rUsers.remove(u);
		u.setRole(null);
	}

}
