package com.springboot.crud.SpringBootDataRestCrudDemo.dao;

import com.springboot.crud.SpringBootDataRestCrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "members") // use members instead of employees for mapping
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
