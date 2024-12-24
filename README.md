# Software Testing & QA Project: Web-Based Calculator

## Introduction

This project is a web-based statistical calculator, created for my Software Testing and Quality Assurance class.
The primary objective of this project is to demonstrate thorough unit testing and end-to-end testing on a usable web application.

The application was written in Java (version 21), using Maven as the build framework and Spring Boot as the execution framework.
JUnit is used to run the unit/end-to-end tests and Microsoft Playwright is used to perform the end-to-end tests.

#### Project Characteristics
- Application performs seven different statistical functions and displays their output
- Application will display a respective error message in the case of a calculation error
- Full coverage is achieved for the logic module through unit testing
- End-to-end testing of each calculator function for full path testing


## Table of Contents

- [Team Members](#team-members)
- [Architecture](#architecture)
- [Environment](#environment)
- [Executing the Web Application](#executing-the-web-application)
- [Executing Unit Tests](#executing-unit-tests)
- [Reviewing Test Coverage](#reviewing-test-coverage)
- [Executing End-To-End Tests](#executing-end-to-end-tests)
- [Final Video Presentation](#final-video-presentation)

## Team Members

- Vera Warren-Aliff, CS Major


## Architecture

-----

This calculator web application is based on an MVC (Model, View, Controller) design.
The MapController class maps the main webpage, or "view," to the server.
The user interacts with this view, which then passes HTTP requests to the OperationController class.
OperationController passes these requests to the "model", or in this case, the calculator logic module.
After a calculation is performed, OperationController passes the result back to the view.

#### UML Class Diagram
![Class Diagram](assets/ClassDiagram.png)

The organization of my project directory is based on the Maven [Standard Directory Layout]((https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)) guidelines given by Apache Maven Project.

#### Directory Structure
![Directory Structure](assets/Directory.png)


## Environment

-----

This is a cross-platform application and should work in Windows 10+, Mac OSx Ventura+, and Linux environments.
Note that the application has only been carefully tested in Windows 11.

To prepare your environment to execute this application:
1. [Install the latest Java runtime for your system.](https://www.java.com/en/download/manual.jsp)


## Executing the Web Application

-----

>  [!IMPORTANT]
> Application execution requires a recent installation of Java.

#### Running JAR Executable
1. Clone this GitHub repository OR download [calculatorApp-1.0.jar](target/calculatorApp-1.0.jar) from the target folder
2. Open a terminal at the directory with the calculatorApp-1.0.jar download
3. Enter the following command into the terminal:
`java -jar calculatorApp-1.0.jar`
4. Open a web browser and go to http://localhost:8080

-----

Alternatively, you may run the project with the Maven Wrapper and SpringBoot.

#### Running with Maven Wrapper
1. Clone this GitHub repository
2. Open a terminal in the project root directory
3. Enter the following command into the terminal:
`mvnw spring-boot:run` 
4. Open a web browser and go to http://localhost:8080


## Executing Unit Tests

-----

>  [!IMPORTANT]
> Unit Test execution will require cloning this GitHub repository.

#### Executing JUnit Tests with Maven Wrapper
1. After cloning the repo, open a command terminal in the project root directory
2. Enter the following command into the terminal: `mvnw test`

## Reviewing Test Coverage

-----

Using JUnit test cases, 100% line and branch coverage was achieved for the logic module (package *calculatorApp.logic*).
Coverage analysis by the IntelliJ IDEA coverage plugin is shown below.

![Coverage](assets/Coverage.png)


## Executing End-To-End Tests

-----

>  [!IMPORTANT]
> End-to-end Test execution will require cloning this GitHub repository.

#### Executing Playwright End-to-end Tests with Maven Wrapper
1. After cloning the repo, open a command terminal in the project root directory
2. Enter the following command into the terminal: `mvnw verify -DskipSurefire=true`

> The `-DskipSurefire=true` argument enables Maven FailSafe to run integration tests without running unit tests first.


## Final Video Presentation

-----

The presentation for this project may be viewed on [Vimeo](https://vimeo.com/1035858697).
