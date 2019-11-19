package com.alexxstepan.taskmanagement.entities;

public enum Priority {
	LOW("Low"),
	MEDIUM("Medium"),
	HIGH("High"),
	IMMEDIATE("Immediate"),
	URGENT("Urgent");

	private String label;

	Priority(String label) {
		this.label = label;
	}

	public static Priority getByLabel(String label) {
		for (Priority status : values()) {
			if (status.getLabel().equals(label))
				return status;
		}

		throw new IllegalArgumentException();
	}

	public String getLabel() {
		return label;
	}
}
