package com.alexxstepan.taskmanagement.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	public Long getId() {
		return id;
	}
}
