package com.enterprise.modal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.enterprise.visitor.Visitable;
import com.enterprise.visitor.Visitor;

@Entity
public class Enterprise implements Serializable, Visitable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition = "VARCHAR(40)")
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@OneToMany(mappedBy="enterprise", cascade = CascadeType.ALL)
	private List<Application> applications;

	public Enterprise() {
		super();
	}

	public Enterprise(Long id, String name, String description, List<Application> applications) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.applications = applications;
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

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public void addApplication(Application app) {
		if (getApplications() == null) {
			applications = new ArrayList<Application>();
		}
		getApplications().add(app);
		app.setEnterprise(this);	
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		if (getApplications() != null) {
			getApplications().forEach(application -> {
				application.accept(visitor);
			});
		}
		
	}
}
