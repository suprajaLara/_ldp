package com.springboot.crud.SpringBootDataJpaCrudDemo.dao;

import com.springboot.crud.SpringBootDataJpaCrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
