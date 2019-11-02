package com.alexxstepan.taskmanagement.controllers;

import com.alexxstepan.taskmanagement.dao.services.TaskService;
import com.alexxstepan.taskmanagement.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

	@Autowired private TaskService taskService;

	@RequestMapping("/all")
	public List<Task> list() {
		return taskService.listTasks();
	}

	@RequestMapping("/{id}")
	public Task get(@PathVariable long id) {
		return taskService.getById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void save(@RequestBody Task task) {
		taskService.save(task);
	}
}
