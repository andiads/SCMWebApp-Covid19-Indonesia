package com.nusacamp.app.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(uniqueConstraints = @UniqueConstraint (columnNames = "mail"))
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	@Column(name="mail")
	private String mail;
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_types",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "user_type_id", referencedColumnName = "id"))
	private Collection<UserType> userTypes;
	
	@CreatedDate
	@Column(name="created_at",nullable=false,updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at",nullable=false)
	private Date updatedAt;

	public User() {
		
	}

	public User(int id, String mail, String fullName, String password) {
		super();
		this.id = id;
		this.mail = mail;
		this.fullName = fullName;
		this.password = password;
	}

	public User(String fullName, String mail, String password, Collection<UserType> userTypes) {
		this.id = id;
		this.mail = mail;
		this.fullName = fullName;
		this.password = password;
		this.userTypes = userTypes;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<UserType> getUserTypes() {
		return userTypes;
	}
	public void setUserTypes(Collection<UserType> userTypes) {
		this.userTypes = userTypes;
	}
	

	@Override
	public String toString() {
		return "User{"+
	"id=" + id + 
	", fullName=" + fullName +'\''+
				", mail=" + mail+'\''+
				", password=" + "********" +'\''+
				", userType=" + userTypes + '}';
	}
	
	
	

}
