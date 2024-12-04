# KSU SWE 3643 Software Testing and Quality Assurance Semester Project: Web-Based Calculator

## Introduction

## Table of Contents

- [Team Members](#team-members)
- [Architecture](#architecture)
- [Environment](#environment)
- [Executing the Web Application](#executing-the-web-application)
- [Executing Unit Tests](#executing-unit-tests)
- [Reviewing Unit Test Coverage](#reviewing-unit-test-coverage)
- [Executing End-To-End Tests](#executing-end-to-end-tests)
- [Final Video Presentation](#final-video-presentation)

## Team Members

- Vera Warren-Aliff, CS Major

## Architecture

The organization of my project directory differs slightly from the example format so that I may follow the official [Standard Directory Layout]((https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)) guidelines given by the Apache Maven Project.
In my experience, organizing my project by this standard format prevents Maven build issues.

## Environment

-----

## Executing the Web Application

>  [!IMPORTANT]
>
> Execution requires a recent installation of Java. Linux compatibility is not ensured.

#### Running JAR Executable
1. Download [calculatorApp-1.0.jar](target/calculatorApp-1.0.jar) from the target folder OR clone this GitHub repository
2. Open a terminal at the directory with the calculatorApp-1.0.jar download
3. Enter the following command into the terminal:

       java -jar calculatorApp-1.0.jar
4. Open a web browser and go to http://localhost:8080

*If this process fails, please ensure your installation of Java is up to date.*

-----

Alternatively, you may run the project with the Maven Wrapper and SpringBoot.

#### Running with Maven Wrapper
1. Clone this GitHub repository
2. Open a terminal in the project root directory
3. Enter the following command into the terminal:

       mvnw spring-boot:run 
4. Open a web browser and go to http://localhost:8080

## Executing Unit Tests

-----

Unit tests may be executed with the Maven Wrapper in the project root directory.

#### Executing Unit Tests with Maven Wrapper
1. Clone this GitHub repository
2. Open a terminal in the project root directory
3. Enter the following command into the terminal:

       mvnw test

## Reviewing Unit Test Coverage

-----

## Executing End-To-End Tests

-----

## Final Video Presentation

-----
