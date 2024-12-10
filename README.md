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

### 2. Currency Conversion Service
- **Purpose**: Converts one currency to another using exchange rates from the Currency Exchange Service.
- **Features**:
  - Communicates with the Currency Exchange Service using Feign or REST template.
  - Performs the conversion based on the retrieved exchange rate.
  - Registers itself with the Naming Server.

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

1. [Docker](https://www.docker.com/get-started) - to run Zipkin for distributed tracing.
2. Java 17 (or compatible version).
3. Maven 3.6+.
4. Spring Boot CLI (optional, for rapid development).

---

## Running the Application

Follow these steps to set up and run the application:

### Step 1: Clone the Repository
Pull the Git repository to your local system:
```
git clone https://github.com/opmalhi/microservices-with-spring-cloud.git
```

### Step 2: Start the Application
Go to the terminal and move to git repository folder where docker-compose.yaml file will be present:

```
cd <repository-folder>
docker-compose up
```

This will automatically start all the required microservices and dependencies.

## Docker Image for Currency Exchange Service
The Docker image for the Currency Exchange Service is available as:
opmalhi/microservice-currency-exchange-service:0.0.1-SNAPSHOT

---

## To Resolve `Connection timed out: getsockopt` Problem
If you encounter a `Connection timed out: getsockopt` issue, add the following line to the `application.properties` file in every microservice you are sending requests to:
```
eureka.instance.prefer-ip-address=true
```