package com.alexxstepan.taskmanagement.dao.services;

import com.alexxstepan.taskmanagement.dao.repositories.TaskRepository;
import com.alexxstepan.taskmanagement.entities.Task;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

	@Autowired private TaskRepository taskRepository;

	public List<Task> listTasks() {
		return IterableUtils.toList(taskRepository.findAll());
	}

	public Optional<Task> getById(long id) {
		return taskRepository.findById(id);
	}

	public void save(Task task) {
		taskRepository.save(task);
	}
}
