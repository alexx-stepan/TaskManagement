package com.alexxstepan.taskmanagement.entities;

public enum TaskStatus {
	NEW("New"),
	IN_PROGRESS("In progress"),
	RESOLVED("Resolved"),
	CLOSED("Closed"),
	REOPENED("Reopened");

	private String label;

	TaskStatus(String label) {
		this.label = label;
	}

	public static TaskStatus getByLabel(String label) {
		for (TaskStatus status : values()) {
			if (status.getLabel().equals(label))
				return status;
		}

		throw new IllegalArgumentException();
	}

	public String getLabel() {
		return label;
	}
}
