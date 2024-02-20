package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping; // Add this import statement

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    public EmployeeController() {
        System.out.println("EmployeeController created");
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

