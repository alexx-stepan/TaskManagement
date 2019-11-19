package com.alexxstepan.taskmanagement.controllers;

import com.alexxstepan.taskmanagement.dao.services.TaskUpdateService;
import com.alexxstepan.taskmanagement.entities.TaskUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tasks/updates")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskUpdateController {

	@Autowired private TaskUpdateService taskUpdateService;

	@RequestMapping("/all/{id}")
	public List<TaskUpdate> list(@PathVariable long id) {
		return taskUpdateService.listTaskUpdates(id);
	}
}
