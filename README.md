# Inventory API

Welcome to the Inventory API! This is a simple RESTful API built with Spring Boot that provides endpoints for managing inventory items. The application is designed to facilitate dynamic decision-making by providing real-time access to inventory data.

## Table of Contents

- [Features](#features)
- [Purpose](#purpose)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Running the Application](#running-the-application)
- [License](#license)

## Features

- RESTful API for inventory management
- In-memory H2 database for testing
- Actuator endpoints for monitoring and management

## Purpose

The Inventory API is developed to support businesses in making informed and dynamic decisions regarding their inventory management. It allows users to:

- **Monitor Inventory Levels**: Keep track of stock levels in real-time to avoid shortages or overstock situations.
- **Analyze Trends**: Use historical data to identify trends and adjust inventory accordingly, ensuring optimal stock levels.
- **Facilitate Quick Decisions**: Provide instant access to inventory data, enabling quick responses to changes in demand or supply chain disruptions.

## Technologies

- Java 21
- Spring Boot
- H2 Database
- Gradle

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or later
- Gradle

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/1927-med/inventory.git
   cd inventory

### Build the application:
    ./gradlew build

### Run the application:
    ./gradlew bootRun

## API Endpoints

    GET / - Welcome message
    /actuator - Actuator endpoints for monitoring
    /h2-console - H2 database console (default username: sa, password: "")

## Database

This API uses an in-memory H2 database. You can access the H2 console at http://localhost:8080/h2-console using the following credentials:

    JDBC URL: jdbc:h2:mem:inventorydb
    Username: sa
    Password: (leave it empty)

## Running the Application

# To run the application, use the following command:
    ./gradlew bootRun


### Instructions to Create the README File

1. Create a file named `README.md` in the root directory of your project.
2. Copy and paste the above content into the `README.md` file.
3. Customize any sections as necessary, especially the "Getting Started" and "API Endpoints" sections, to include any additional endpoints or specific instructions for your application.

## Creater Note
    I am a university student and would like any advice for improvement and i will continue to upgrade the project 

