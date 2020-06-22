import com.alexxstepan.taskmanagement.Application;
import com.alexxstepan.taskmanagement.dao.repositories.EmployeeRepository;
import com.alexxstepan.taskmanagement.entities.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = Application.class)
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	// need test containers
	private List<Employee> employees;

	@Before
	public void setUp() {
		employees = new ArrayList<>();
		employees.add(new Employee("first1", "last1", "1email.gmail.com", "1234567890"));
		employees.add(new Employee("first2", "last2", "2email.gmail.com", "1234567890"));
		employees.add(new Employee("first2", "last2", "2email.gmail.com", "1234567890"));
		employees.add(new Employee("first3", "last3", "3email.gmail.com", "1234567890"));

		employeeRepository.saveAll(employees);
	}

	@After
	public void cleanUp() {
		employeeRepository.deleteAll(employees);
		employees = null;
	}

	@Test
	public void testFindByFirstName() {
		List<Employee> employees = employeeRepository.findByFirstName("first2");

		assertEquals(2, employees.size());
	}
}
