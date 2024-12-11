# Java Microservices with Spring Cloud 

This project demonstrates a Java-based microservices architecture built using Spring Boot and Spring Cloud. 
The system consists of multiple microservices designed for **currency exchange** and **currency conversion** that interact with each other. 
Additional services include an API Gateway and a Naming Server to enable service discovery and registration.

---

## Microservices Overview

### 1. Currency Exchange Service
- **Purpose**: Handles real-time currency exchange rates and exposes APIs to fetch them.
- **Features**:
  - Fetch exchange rates for different currency pairs.
  - Registers itself with the Naming Server for service discovery.
  - Docker image: opmalhi/microservice-currency-exchange-service:0.0.1-SNAPSHOT

### 2. Currency Conversion Service
- **Purpose**: Converts one currency to another using exchange rates from the Currency Exchange Service.
- **Features**:
  - Communicates with the Currency Exchange Service using Feign or REST template.
  - Performs the conversion based on the retrieved exchange rate.
  - Registers itself with the Naming Server.
  - Docker image: opmalhi/microservice-currency-conversion-service:0.0.1-SNAPSHOT

### 3. API Gateway
- **Purpose**: Acts as a single entry point for all the microservices.
- **Features**:
  - Routes requests to appropriate microservices.
  - Implements centralized logging and monitoring.
  - Handles cross-cutting concerns like authentication and throttling.

### 4. Naming Server (Eureka Server)
- **Purpose**: Enables service discovery and load balancing.
- **Features**:
  - Registers all microservices.
  - Ensures that instances of the same service can be load-balanced.

---

## Prerequisites

Before running the microservices, ensure the following are installed:

1. [Docker](https://www.docker.com/get-started) - to run the services and Zipkin for distributed tracing.
2. Java 17 (or compatible version) (optional, if not using Docker images).
3. Maven 3.6+ (optional, if not using Docker images).
4. Docker Compose - for orchestrating all services.

---

## Running the Application

Follow these steps to set up and run the application:

### Step 1: Pull the Git Repository
Clone the repository and navigate to its folder:
```
git clone https://github.com/opmalhi/microservices-with-spring-cloud.git
cd <repository-folder>
```

### Step 2: Start the Services with Docker Compose
Run the following command to start all services, including the Naming Server:
```
docker-compose up
```

This will automatically start all the required microservices and dependencies.

### Step 3: Access the Services
- Currency Exchange API:
Example: `http://localhost:8000/currency-exchange/from/USD/to/PKR`

- Currency Conversion API:
Example: `http://localhost:8100/currency-conversion-feign/from/USD/to/PKR/quantity/10`

- Naming Server (Eureka):
Eureka: `http://localhost:8761/eureka`

## Docker Image for Currency Exchange Service
The Docker image for the Currency Exchange Service is available as:
opmalhi/microservice-currency-exchange-service:0.0.1-SNAPSHOT

---

## To Resolve `Connection timed out: getsockopt` Problem
If you encounter a `Connection timed out: getsockopt` issue, add the following line to the `application.properties` file in every microservice you are sending requests to:
```
eureka.instance.prefer-ip-address=true
```