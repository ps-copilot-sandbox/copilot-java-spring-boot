package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping; // Add this import statement

import java.util.ArrayList;
import java.util.List;


import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // create a new method in the EmployeeController from com.example.demo.model package to get all employees from the database using the EmployeeRepository
    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Create a new endpoint to add a new employee to the database endpoint is /add
    // The method should accept an HTTP POST request and a request body of type Employee
    // The method should return the added employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    


    @GetMapping("/all")
    public List<String> getEmployees() {
        System.err.println("getEmployees called");
        List<String> employees = new ArrayList<String>();
        employees.add("John");
        employees.add("Jane");
        employees.add("Jack");
        employees.add("Jill");
        return employees;
    }
}

