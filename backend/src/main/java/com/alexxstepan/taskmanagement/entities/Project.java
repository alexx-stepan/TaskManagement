package com.alexxstepan.taskmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "tm", name = "PROJECTS")
public class Project extends BaseEntity {

	private Long id;
	private String name;

	public Project() {}

	public Project(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
