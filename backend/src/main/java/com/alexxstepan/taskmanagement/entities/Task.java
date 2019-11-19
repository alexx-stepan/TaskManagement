package com.alexxstepan.taskmanagement.entities;

import com.alexxstepan.taskmanagement.PsqlPriorityConverter;
import com.alexxstepan.taskmanagement.PsqlTaskStatusConverter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(schema = "tm", name = "TASKS")
@TypeDefs({
		@TypeDef(
				name = "pgsql_status_enum",
				typeClass = PsqlTaskStatusConverter.class
		),
		@TypeDef(
				name = "pgsql_priority_enum",
				typeClass = PsqlPriorityConverter.class
		)
})
public class Task extends BaseEntity {

	private Long parentTaskId;
	private Long assigneeId;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "tm.TASK_STATUS")
	@Type( type = "pgsql_status_enum" )
	private TaskStatus status;
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "tm.PRIORITY")
	@Type( type = "pgsql_priority_enum" )
	private Priority priority;

	public Task() {}

	public Task(Long parentTaskId, Long assigneeId, TaskStatus status, String title, String description, Priority priority) {
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

	public TaskStatus getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
}
