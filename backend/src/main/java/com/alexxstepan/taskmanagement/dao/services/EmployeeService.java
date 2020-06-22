package com.alexxstepan.taskmanagement.dao.services;

import com.alexxstepan.taskmanagement.dao.repositories.EmployeeRepository;
import com.alexxstepan.taskmanagement.entities.Employee;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

	@Autowired private EmployeeRepository repository;

	public List<Employee> listEmployees() {
		return IterableUtils.toList(repository.findAll());
	}

	public Optional<Employee> getEmployeeById(long employeeId) {

		return repository.findById(employeeId);
	}
}
