package com.springboot.thymeleaf.demo;

import com.springboot.thymeleaf.demo.dao.EmployeeRepository;
import com.springboot.thymeleaf.demo.entity.Employee;
import com.springboot.thymeleaf.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ThymeleafDemoApplicationTests {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@MockBean //to mock the repository
	private EmployeeRepository employeeRepository;

	@Test
	public void findAllTest() {
		when(employeeRepository.findAllByOrderByLastNameAsc()).thenReturn(Stream
					.of(new Employee(20,"John","Smith","john@gmail.com"),
							new Employee(30,"Abraham","Lincoln","abraham@gmail.com"))
					.collect(Collectors.toList()));
		assertEquals(2,employeeService.findAll().size()); //expected or actual is the size of list returned
	}

	@Test
	public void findByIdTest() {
		Integer id=20;
//		Optional<Employee> result = employeeRepository.findById(id);
		when(employeeRepository.findById(id)).thenReturn(java.util.Optional.of(new Employee(20,"John","Smith","john@gmail.com")));
		//works only when equals() is overrided in Entity(Employee) class, since object references are different
		assertEquals(new Employee(20,"John","Smith","john@gmail.com"),employeeService.findById(id));
	}

	@Test
	public void saveTest() {
		Employee employee = new Employee(20,"John","Smith","john@gmail.com");
		employeeService.save(employee);
		verify(employeeRepository,times(1)).save(employee);
	}

	@Test
	public void deleteByIdTest(){
		Integer id=20;
		when(employeeRepository.findById(id)).thenReturn(java.util.Optional.of(new Employee(20,"John","Smith","john@gmail.com")));
		employeeService.deleteById(id);
		//verify the behavior (testing whether mock method is being called)
		verify(employeeRepository,times(1)).deleteById(id);
	}

	@Test
	void contextLoads() {
	}

}
