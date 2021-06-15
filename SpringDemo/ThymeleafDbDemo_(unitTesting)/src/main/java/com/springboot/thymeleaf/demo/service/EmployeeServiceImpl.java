package com.springboot.thymeleaf.demo.service;

import com.springboot.thymeleaf.demo.dao.EmployeeRepository;
import com.springboot.thymeleaf.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private Logger logger = Logger.getLogger(getClass().getName());

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
//        return employeeRepository.findAll();

        List<Employee> employeeList = employeeRepository.findAllByOrderByLastNameAsc();
        logger.info(">>>>> Getting data from database (mocking): "+employeeList);
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        }
        else{
            throw new RuntimeException("Did not find employee with id:"+id);
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
