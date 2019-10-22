package com.alexxstepan.taskmanagement.dao.repositories;

import com.alexxstepan.taskmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("employees")
@Repository
public interface EmployeeRepository extends ApplicationRepository<Employee> {

	List<Employee> findByFirstName(String firstName);
}
