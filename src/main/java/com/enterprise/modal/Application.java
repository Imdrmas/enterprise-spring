package com.enterprise.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.enterprise.visitor.Visitable;
import com.enterprise.visitor.Visitor;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Application implements Visitable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition="VARCHAR(40)")
	private String name;
	
	@Column(columnDefinition="VARCHAR(40)")
	private String description;
	
	private Language language;
	
	private Criticality criticality;
	
	@JsonBackReference(value = "user")
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@JsonBackReference(value = "enterprise")
	@ManyToOne
	private Enterprise enterprise;

	public Application() {
		super();
	}
	public Application(String name, String description, Language language, Criticality criticality, User user) {
		super();
		this.name = name;
		this.description = description;
		this.language = language;
		this.criticality = criticality;
		this.user = user;
	}
	
	public Application(String name, String description, Language language, Criticality criticality, User user,
			Enterprise enterprise) {
		super();
		this.name = name;
		this.description = description;
		this.language = language;
		this.criticality = criticality;
		this.user = user;
		this.enterprise = enterprise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Criticality getCriticality() {
		return criticality;
	}

	public void setCriticality(Criticality criticality) {
		this.criticality = criticality;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);	
	}
}
