package com.alexxstepan.taskmanagement.controllers;

import com.alexxstepan.taskmanagement.dao.services.EmployeeService;
import com.alexxstepan.taskmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired private EmployeeService employeeService;

	@RequestMapping("/all")
	public List<Employee> list() {
		return employeeService.listEmployees();
	}
}
