package com.alexxstepan.taskmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "tm", name = "TASKS")
public class Task extends BaseEntity {

	private Long parentTaskId;
	private Long performerId;
	private Byte statusId;
	private String description;

	public Task() {}

	public Task(Long parentTaskId, Long performerId, Byte statusId, String description) {
		this.parentTaskId = parentTaskId;
		this.performerId = performerId;
		this.statusId = statusId;
		this.description = description;
	}

	public Long getParentTaskId() {
		return parentTaskId;
	}

	public Long getPerformerId() {
		return performerId;
	}

	public Byte getStatusId() {
		return statusId;
	}

	public String getDescription() {
		return description;
	}

	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public void setPerformerId(Long performerId) {
		this.performerId = performerId;
	}

	public void setStatusId(Byte statusId) {
		this.statusId = statusId;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
