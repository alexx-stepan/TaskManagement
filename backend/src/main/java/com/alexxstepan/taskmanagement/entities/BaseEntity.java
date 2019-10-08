package com.alexxstepan.taskmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Long id;

	public Long getId() {
		return id;
	}
}
