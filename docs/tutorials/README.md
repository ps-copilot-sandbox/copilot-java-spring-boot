# Getting started

To follow the instructions in this tutorial, you need to switch to the branch `api`. 

## Branches

- `main` - This branch contains the initial code for the application.
- `api` - This branch contains the restful API for the application.
- `api-static` - This branch contains the initial version of the restful API for the application.

## How to run the application

I use `mvn clean spring-boot:run` to run the application. Alternatively, you can run the application from your IDE, or build the application and run the jar file from your terminal or deploy to a web server.

### Application URL

The base url for the application is `http://localhost:8080/employees`

- Static endpoint to get employees: `http://localhost:8080/employees/all`
- Endpoint to get employees from the database: `http://localhost:8080/employees/employees`
- Endpint to add an employee: `http://localhost:8080/employees/add`

## Application confoguration

### application.properties

```properties
spring.datasource.url=jdbc:h2:./data/test
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### main class

Main class is `com.example.demo.DemoApplication`

### Add a controller - create a controller with static data

Add a controller empty class `com.example.demo.controller.EmployeeController`

I ask Copilot to suggest the code for the controller and it suggested the following code: This is the first version of API

![image](https://github.com/snsinahub-org/copilot-java-spring-boot/assets/90400593/b54d02ff-f39c-4537-a6b3-738e1aa3e95a)
![image](https://github.com/snsinahub-org/copilot-java-spring-boot/assets/90400593/6508506a-fb94-43af-b37e-83ad6cf6daec)

```java
// create a new controller class called EmployeeController
// and annotate it with @RestController
// add RequestMapping to /employees

package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class EmployeeController {
    
    @RequestMapping("/employees")
    @GetMapping
    public List<String> getEmployees() {
        List<String> employees = new ArrayList<String>();
        employees.add("John");
        employees.add("Jane");
        employees.add("Jack");
        employees.add("Jill");
        return employees;
    }
}
```

You can find this version of api in the branch `api-static`.

## Improve our API to get data from the database


### Creating an entity class and a repository

We will improve our API to get data from the database. To do so, we will ask Copilot to suggeest the code for `Employee` entity, `EmployeeRepository`. 

First create a class in `com.example.demo.model` package called `Employee` and ask Copilot to suggest the code for the class. There are 2 ways to ask Copilot to suggest the code for the class: Chat or inline suggestions. I used chat to ask Copilot to suggest the code for the class. 

This is my question to Copilot:

```text
create an entity class Employee using lombok
"@Data: generate getters and setters
@AllArgsConstructor: generate constructor with all fields
@NoArgsConstructor: generate constructor with no fields
@Entity: mark this class as an entity class
@Table: map this class to a table named employees
@Id: mark this field as the primary key
@GeneratedValue: generate the value for this field automatically
@Column: map this field to a column named id
@Column: map this field to a column named name
@Column: map this field to a column named email
"
```

This is the code suggested by Copilot:

```java
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // adding this constructor to create an instance of the class with the name and email fields
    // this is suggested by Copilot after copying the code above
    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
```


Create a new class `EmployeeRepository` in the package `com.example.demo.repository` and ask Copilot to suggest the code for the class. This is the question I asked Copilot:

```text
 create EmployeeRepository JPA repository interface manging Employee entity class in the same package
```

This is the code suggested by Copilot:

```java
mport org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```

### Include the repository in the controller

Now we need to include the repository in the controller. I asked Copilot to suggest the code for the controller. This is the question I asked Copilot:

```text
create a new method in the EmployeeController to get all employees from the database using the EmployeeRepository
```

This is the code suggested by Copilot: (in-line suggestion)

```java
 @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
```


### add a new endpoint to add a new employee

I asked Copilot to suggest the code for the controller to add a new employee. This is the question I asked Copilot:

```Java
    // Create a new endpoint to add a new employee to the database endpoint is /add
    // The method should accept an HTTP POST request and a request body of type Employee
    // The method should return the added employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
```

### adding a new employee

here is the curl command to add a new employee:

```bash
curl --location 'http://localhost:8080/employees/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "siavash",
    "email": "siavash@mail.com"
}'
```

### list all employees

You can list all employees from database using the following curl command:

```bash
curl --location --request GET 'http://localhost:8080/employees/employees'
```

