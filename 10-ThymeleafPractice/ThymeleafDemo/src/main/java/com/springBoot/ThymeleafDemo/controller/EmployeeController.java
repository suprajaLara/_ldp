package com.springBoot.ThymeleafDemo.controller;

import com.springBoot.ThymeleafDemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //load employee data
    private List<Employee> employeeList;

    @PostConstruct
    private void loadData(){
        // create employees
        Employee employee1=new Employee(1,"Lara","Croft","croft@gmail.com");
        Employee employee2=new Employee(2,"Emma","Jackson","jack@gmail.com");
        Employee employee3=new Employee(3,"Larry","Page","page@gmail.com");

        // create list
        employeeList = new ArrayList<>();

        // add to list
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees",employeeList);
        return "list-employees";
    }
}
