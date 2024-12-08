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

### Step 1: Start Zipkin for Distributed Tracing
Run the following Docker command to start Zipkin for distributed tracing:
```
docker run -p 9411:9411 openzipkin/zipkin:latest
```

### Step 2: Start the Naming Server
Navigate to the `naming-server` directory and run the Naming Server:

```
cd naming-server
./mvnw spring-boot:run
```

or open currency exchange project and start the application

### Step 3: Start the Currency Exchange Service
Navigate to the `currency-exchange-service` directory and start the service:
```
cd currency-exchange-service
./mvnw spring-boot:run
```

### Step 4: Start the Currency Conversion Service
Navigate to the `currency-conversion-service` directory and start the service:
```
cd currency-conversion-service
./mvnw spring-boot:run
```

### Step 5: Start the API Gateway Service
Navigate to the `api-gateway` directory and start the service:
```
cd api-gateway
./mvnw spring-boot:run
```

or open currency exchange project and start the application

## Monitoring and Logging
First it this url `http://localhost:8000/currency-exchange/from/USD/to/PKR` and then go to Zipkin dashboard
- Zipkin: Access the Zipkin dashboard at `http://localhost:9411` to monitor and trace requests.


## To Resolve `Connection timed out: getsockopt` problem 
- add below line to application.properties in every microservice you are sending request to
```
eureka.instance.prefer-ip-address=true
```