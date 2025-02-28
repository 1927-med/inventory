# Inventory API

Welcome to the Inventory API! This is a RESTful API built with Spring Boot that helps businesses manage their inventory efficiently. 
The application not only provides basic CRUD operations for inventory items but also implements a dynamic ordering algorithm to optimize inventory decisions over time.
## Table of Contents

- [Features](#features)
- [Purpose](#purpose)
- [Dynamic Ordering Algorithm]
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Running the Application](#running-the-application)
- [License](#license)

## Features

- RESTful API for inventory management
- Dynamic Ordering Algorithm to optimize inventory decisions
- In-memory H2 database for testing
- Actuator endpoints for monitoring and management
- H2 Console for easy database access during development.

## Purpose

The Inventory API is developed to support businesses in making informed and dynamic decisions regarding their inventory management. It allows users to:

- **Monitor Inventory Levels**: Keep track of stock levels in real-time to avoid shortages or overstock situations.
- **Optimize Ordering Decisions**: Use the Dynamic Ordering Algorithm to determine the optimal order quantities over time, minimizing costs.
- **Analyze Trends**: Use historical data to identify trends and adjust inventory accordingly, ensuring optimal stock levels.
- **Facilitate Quick Decisions**: Provide instant access to inventory data, enabling quick responses to changes in demand or supply chain disruptions.

## Dynamic Ordering Algorithm
The Dynamic Ordering Algorithm is a key feature of this application. It uses dynamic programming to solve the inventory ordering problem by breaking it into smaller sub-problems and solving them in reverse order (backward recursion). Here's how it works:

Problem Statement

You run a production facility with known demands for materials in each time period.
At the beginning of each period, you can order a certain amount of material.
The goal is to minimize the total cost, which includes:
Ordering Cost: A fixed cost for placing an order.
Holding Cost: The cost of holding inventory from one period to the next.

## How It Works
Stages and States:
Each time period represents a stage.
The state at each stage is the inventory level at the end of the period.
Backward Recursion:
Start from the last period and work backward to the first.
At each stage, calculate the optimal cost for each possible inventory level.
Cost Function:
The cost function includes:
Ordering Cost: Fixed cost if an order is placed.
Holding Cost: Cost of holding inventory to the next period.
Optimal Policy:
The algorithm determines the optimal order quantities for each period to minimize total costs.
Example

For a demand sequence [10, 20, 30, 40], the algorithm calculates the optimal order quantities and associated costs for each period.

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
   Inventory Management

   GET /api/items: Get all inventory items.
   POST /api/items: Add a new inventory item.
   GET /api/items/{id}: Get an item by ID.
   PUT /api/items/{id}: Update an item by ID.
   DELETE /api/items/{id}: Delete an item by ID.
   
Dynamic Ordering Algorithm

   POST /api/ordering/solve: Solve the dynamic ordering problem.
   Parameters:
   orderingCost: Fixed cost for placing an order.
   holdingCost: Cost of holding one unit of inventory.
   demands: Array of demands for each time period (e.g., [10, 20, 30, 40]).

Actuator Endpoints

   GET /actuator: Access actuator endpoints for monitoring and management.
   
H2 Console
   Access H2 Console: http://localhost:8080/h2-console
      JDBC URL: jdbc:h2:mem:inventorydb
      Username: sa
      Password: (leave it empty)


## Database

This API uses an in-memory H2 database. You can access the H2 console at http://localhost:8080/h2-console to view and interact with the database.



## Running the Application

# To run the application, use the following command:
    ./gradlew bootRun


### Instructions to Create the README File

1. Create a file named `README.md` in the root directory of your project.
2. Copy and paste the above content into the `README.md` file.
3. Customize any sections as necessary, especially the "Getting Started" and "API Endpoints" sections, to include any additional endpoints or specific instructions for your application.

## Creater Note
    I am a university student and would like any advice for improvement and i will continue to upgrade the project 

