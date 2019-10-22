package com.alexxstepan.taskmanagement.dao.services;

import com.alexxstepan.taskmanagement.dao.repositories.TaskRepository;
import com.alexxstepan.taskmanagement.entities.Task;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {

	@Autowired private TaskRepository taskRepository;

	public List<Task> listTasks() {
		return IterableUtils.toList(taskRepository.findAll());
	}

	public Task getById(long id) {
		return taskRepository.findById(id).orElse(null);
	}

	public void save(Task task) {
		taskRepository.save(task);
	}
}
