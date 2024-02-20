package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping; // Add this import statement

import java.util.ArrayList;
import java.util.List;


import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


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
    

    // Create a new endpoint to get a single employee from the database by id path: /employees/{id}
    // The endpoint should accept an HTTP GET request and a path variable of type Long
    // The endpoint should return the employee with the given id

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    // Create a new endpoint to update an employee in the database by id path: /employees/{id}
    // The endpoint should accept an HTTP PUT request, a path variable of type Long, and a request body of type Employee
    // The endpoint should return the updated employee

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }


    // Create a new endpoint to delete an employee from the database by id path: /employees/{id}
    // The endpoint should accept an HTTP DELETE request and a path variable of type Long
    // The endpoint should return the deleted employee

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            employeeRepository.delete(existingEmployee);
            return existingEmployee;
        }
        return null;
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

