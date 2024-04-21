# Creating a Java restful API with GitHub Copilot

## Note

Please refrain from merging branches. The main branch serves as the structure for a Spring Boot application, while each individual branch represents a specific app. These apps are developed based on the main branch and are crafted with the assistance of GitHub Copilot.

## Background

We are going to create a restful API using Java and Spring Boot. We will use GitHub Copilot to help us write the code. The Api will be a simple CRUD application that will allow us to create, read, update and delete employees from a database.

For writing the code and documentation, I am getting help from GitHub Copilot. 

## What is GitHub Copilot?

GitHub Copilot is an AI pair programmer that helps you write code faster. It is available as IDE extensions. It is also available in other IDEs. You can learn more about GitHub Copilot [here](https://docs.github.com/en/copilot/using-github-copilot/getting-started-with-github-copilot).

There are 2 types of copilot extensions:
- GitHub Copilot for in-editor suggestions
- GitHub Copilot for chat suggestions




## Java Application overview

This is a Java Spring Boot application. The application has following depndencies:

- Spring Web
- Spring Data JPA
- h2 Database
  
in the branch `api` we will create a restful API that will allow us to create, read, update and delete employees from a database. 

## Using Spring Boot Initializr to generate the application structure

<img width="1608" alt="image" src="https://github.com/snsinahub-org/copilot-java-spring-boot/assets/90400593/ca7fdb8b-9e09-44dd-b07b-2ad0caf3eba6">

I utilized the [Spring Boot Initializr](https://start.spring.io/) t) to generate the structure of this application. This tool provides a straightforward web UI that enables you to configure your application's foundational aspects. Within the web UI, you have the option to specify the language, project type, Spring Boot version, and add the necessary dependencies. 

## How Copilot helped me to write the code?

I used GitHub Copilot to write the code and documentation. I used Copilot suggestions in the `editor` and via `chat`. 

I used these 2 methods to get help from Copilot:

1. Copilot suggestions in the editor
2. Copilot suggestions in the chat

### Copilot suggestions in the editor

Copilot suggests code in the editor in the following ways:

1. When I write a comment, Copilot suggests code based on the comment.
2. When I write a method, Copilot suggests the method body.
3. Autocomplete suggestions based on the context.
4. Inline chat suggestions.
5. Explaination of the code.
6. Fix the code
7. Generate codes
8. Generate test

### Copilot suggestions in the chat

I can ask questions and Copilot suggested code based on the question. very similar to the in-editor suggestions.

## Pre-requisites

- Java 17
- Maven
- IDE - I used Visual Studio Code please refere to list of Copilot supported IDEs [here](https://docs.github.com/en/copilot/using-github-copilot/getting-started-with-github-copilot?tool=azure_data_studio)
- h2 database - I used h2 database for this application. You can use any other database as well.
- Postman - for testing the API
- Git - for version control
- GitHub - for hosting the code
- Copilot - for writing the code and documentation 

## About Copilot suggested code

Most of suggested codes are in-editor suggestions, I use comments to get suggestions and you can see the comments in the code and try to reproduce the same in your code.

You can follow the instructions in [Getting Started](docs/tutorials/README.md). 

## Accepting, rejecting or modifying Copilot suggestions

You have freedom to accept or deny the suggested code, or modify the code either manually or ask Copilot to modify it itself.


