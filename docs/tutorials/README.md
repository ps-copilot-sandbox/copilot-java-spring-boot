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

## Modify 


