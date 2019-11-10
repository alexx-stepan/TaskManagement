package com.alexxstepan.taskmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "tm", name = "TASKS")
public class Task extends BaseEntity {

	private Long parentTaskId;
	private Long assigneeId;
	private String status;
	private String title;
	private String description;
	private String priority;

	public Task() {}

	public Task(Long parentTaskId, Long assigneeId, String status, String title, String description, String priority) {
		this.parentTaskId = parentTaskId;
		this.assigneeId = assigneeId;
		this.status = status;
		this.title = title;
		this.description = description;
		this.priority = priority;
	}

	public Long getParentTaskId() {
		return parentTaskId;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public String getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPriority() {
		return priority;
	}

	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
}
