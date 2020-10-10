package com.alexxstepan.taskmanagement.controllers;

import com.alexxstepan.taskmanagement.dao.services.EmployeeService;
import com.alexxstepan.taskmanagement.dao.services.ProjectService;
import com.alexxstepan.taskmanagement.dao.services.TaskService;
import com.alexxstepan.taskmanagement.entities.Employee;
import com.alexxstepan.taskmanagement.entities.Project;
import com.alexxstepan.taskmanagement.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

	@Autowired private TaskService taskService;
	@Autowired private ProjectService projectService;
	@Autowired private EmployeeService employeeService;

	@RequestMapping("/all")
	public List<Task> list() {
		return taskService.listTasks();
	}

	@RequestMapping("/{id}")
	public Task get(@PathVariable long id) {
		Optional<Task> task = taskService.getById(id);

		return task.orElseThrow(() -> {
			return new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no task with ID " + id);
		});
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void save(@RequestBody Task task) {
		taskService.save(task);
	}

	@RequestMapping("/projectname/{projectId}")
	public String getProjectName(@PathVariable long projectId) {
		Optional<Project> project = projectService.getProjectById(projectId);

		if (project.isPresent())
			return project.get().getName();

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no project with ID " + projectId);
	}

	@RequestMapping("/assigneename/{employeeId}")
	public String getAssigneeName(@PathVariable long employeeId) {
		Optional<Employee> employee = employeeService.getEmployeeById(employeeId);

		if (employee.isPresent())
			return employee.get().getFirstName() + " " + employee.get().getLastName();

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no employee with ID " + employeeId);
	}
}
