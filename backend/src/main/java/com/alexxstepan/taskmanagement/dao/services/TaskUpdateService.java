package com.alexxstepan.taskmanagement.dao.services;

import com.alexxstepan.taskmanagement.dao.repositories.TaskUpdateRepository;
import com.alexxstepan.taskmanagement.entities.TaskUpdate;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskUpdateService {

	@Autowired private TaskUpdateRepository taskUpdateRepository;

	public List<TaskUpdate> listTaskUpdates(long taskId) {
		return IterableUtils.toList(taskUpdateRepository.findByRelatedTaskId(taskId));
	}
}
