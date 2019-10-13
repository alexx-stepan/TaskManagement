package com.alexxstepan.taskmanagement.controllers;

import com.alexxstepan.taskmanagement.dao.services.TaskService;
import com.alexxstepan.taskmanagement.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired private TaskService taskService;

	@RequestMapping("/all")
	public List<Task> list() {
		return taskService.listTasks();
	}
}
