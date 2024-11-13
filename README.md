# ClassicModels Microservices Application

## Overview
This project is a Spring Boot-based microservices application built on top of the `classicmodels` MySQL database. It demonstrates key concepts of microservices architecture, including service-to-service communication, RESTful APIs, and database interaction.

## Features
- **Customer Service**: Manages customer data.
- **Order Service**: Handles orders and order details, with integration to Customer Service.
- **Employee Service**: Manages employee data.
- **Payment Service**: Processes payments.
- **Order Details Service**: Manages items for each order.

## Technologies Used
- **Spring Boot**: Framework for building microservices.
- **Spring Data JPA**: For database interaction using JPA entities.
- **RestTemplate**: For inter-service communication.
- **MySQL**: Database for storing application data.
- **New Relic**: For application monitoring.
- **JUnit 5**: For unit testing and integration testing.
- **Maven**: For building and managing dependencies.

## Prerequisites
- Java 11 or higher
- MySQL Database (running locally or remotely)
- Maven (for building the project)

## Setup Instructions
### 1. Clone the Repository:
```bash
git clone https://github.com/yourusername/your-repo-name.git
