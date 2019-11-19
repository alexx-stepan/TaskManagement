package com.alexxstepan.taskmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity()
@Table(schema = "tm", name = "TASK_UPDATES")
public class TaskUpdate extends BaseEntity {

	private Long relatedTaskId;
	private String message;
	@Column(name = "status_old")
	private String oldStatus;
	@Column(name = "status_new")
	private String newStatus;
	@Column(name = "assignee_old_id")
	private Long oldAssigneeId;
	@Column(name = "assignee_new_id")
	private Long newAssigneeId;
	@Column(name = "priority_old")
	private String oldPriority;
	@Column(name = "priority_new")
	private String newPriority;
	private Long updatePerformerId;

	public TaskUpdate() {}

	public TaskUpdate(Long relatedTaskId,
					  String message,
					  String oldStatus,
					  String newStatus,
					  Long oldAssigneeId,
					  Long newAssigneeId,
					  String oldPriority,
					  String newPriority,
					  Long updatePerformerId) {
		this.relatedTaskId = relatedTaskId;
		this.message = message;
		this.oldStatus = oldStatus;
		this.newStatus = newStatus;
		this.oldAssigneeId = oldAssigneeId;
		this.newAssigneeId = newAssigneeId;
		this.oldPriority = oldPriority;
		this.newPriority = newPriority;
		this.updatePerformerId = updatePerformerId;
	}

	public Long getRelatedTaskId() {
		return relatedTaskId;
	}

	public String getMessage() {
		return message;
	}

	public String getOldStatus() {
		return oldStatus;
	}

	public String getNewStatus() {
		return newStatus;
	}

	public Long getOldAssigneeId() {
		return oldAssigneeId;
	}

	public Long getNewAssigneeId() {
		return newAssigneeId;
	}

	public String getOldPriority() {
		return oldPriority;
	}

	public String getNewPriority() {
		return newPriority;
	}

	public Long getUpdatePerformerId() {
		return updatePerformerId;
	}

	public void setRelatedTaskId(Long relatedTaskId) {
		this.relatedTaskId = relatedTaskId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public void setOldAssigneeId(Long oldAssigneeId) {
		this.oldAssigneeId = oldAssigneeId;
	}

	public void setNewAssigneeId(Long newAssigneeId) {
		this.newAssigneeId = newAssigneeId;
	}

	public void setOldPriority(String oldPriority) {
		this.oldPriority = oldPriority;
	}

	public void setNewPriority(String newPriority) {
		this.newPriority = newPriority;
	}

	public void setUpdatePerformerId(Long updatePerformerId) {
		this.updatePerformerId = updatePerformerId;
	}
}
