# Getting started

To follow the instructions in this tutorial, you need to switch to the branch `api`. 

## Branches

- `main` - This branch contains the initial code for the application.
- `api` - This branch contains the restful API for the application.

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


```text


We will use `EmployeeRepository` to get data from the database. To do so, we will create a new class `EmployeeRepository` and use `EmployeeRepository` in the `EmployeeController` to get data from the database.



