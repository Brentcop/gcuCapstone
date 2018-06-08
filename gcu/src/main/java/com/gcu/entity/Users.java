package com.gcu.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "active")
	private int active;

	
	/*
	 * Cascading: allows us to map the data from parent->child entities
	 * 
	 * Fetch:helps w/ pulling data each time we make a call
	 * 
	 */
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_role", 
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns= @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	public Users() {
		
	}

	//creae a constructor to give us the ability to make a copy from the child class
	public Users(Users users) {
		this.id = users.getId();
		this.email = users.getEmail();
		this.password = users.getPassword();
		this.name = users.getName();
		this.lastName = users.getLastName();
		this.active = users.getActive();
		this.roles = users.getRoles();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users id: " + id + ", email: " + email + ", password:  " + password + ", name: " + name + 
				", lastName: "+ lastName + ", active: " + active + ", roles: " + roles + ".";
	}
	
}
