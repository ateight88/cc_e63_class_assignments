package com.tondoy.employee;

import com.tondoy.employee.models.Employee;
import com.tondoy.employee.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployee(){
		Employee Bob = new Employee("Bob", 29, "101", "bob@example.com" );
		employeeRepository.save(Bob);
	}
}
