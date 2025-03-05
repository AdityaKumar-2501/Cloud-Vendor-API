# Cloud Vendor API

This repository contains the source code for a Spring Boot REST API designed to manage cloud vendor information. It provides endpoints for creating, retrieving, updating, and deleting cloud vendor records.

## Table of Contents

-   [Project Description](#project-description)
-   [Features](#features)
-   [Technologies Used](#technologies-used)
-   [Setup Instructions](#setup-instructions)
    -   [Prerequisites](#prerequisites)
    -   [Running the Application](#running-the-application)
-   [API Endpoints](#api-endpoints)
-   [Testing](#testing)
-   [Contributing](#contributing)
-   [License](#license)
-   [Contact](#contact)

## Project Description

The Cloud Vendor API is a backend service developed using Spring Boot. It allows users to manage cloud vendor details through a set of RESTful endpoints. This project serves as a practical example of building a simple CRUD (Create, Read, Update, Delete) API with Spring Boot.

## Features

-   **CRUD Operations:** Supports creating, retrieving, updating, and deleting cloud vendor records.
-   **RESTful API:** Provides a clean and standardized API for interacting with cloud vendor data.
-   **Spring Boot:** Leverages the power of Spring Boot for rapid development and deployment.
-   **In-Memory Data Storage:** Uses an in-memory data store for simplicity (can be easily extended to use a persistent database).
-   **Basic Error Handling:** Includes basic error handling for common scenarios.

## Technologies Used

-   **Java 17+**
-   **Spring Boot**
-   **Maven**
-   **JUnit**
-   **Mockito**

## Setup Instructions

### Prerequisites

-   Java Development Kit (JDK) 17 or higher
-   Maven
-   An IDE (e.g., IntelliJ IDEA, Eclipse, VS Code with Java extensions)

### Running the Application

1.  **Clone the repository:**

    ```bash
    git clone [https://github.com/AdityaKumar-2501/Cloud-Vendor-API.git](https://www.google.com/search?q=https://github.com/AdityaKumar-2501/Cloud-Vendor-API.git)
    cd Cloud-Vendor-API
    ```

2.  **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

3.  **Run the Spring Boot application:**

    ```bash
    mvn spring-boot:run
    ```

    Alternatively, you can run the `CloudVendorApiApplication.java` class directly from your IDE.

4.  The API will be available at `http://localhost:8080`.

## API Endpoints

-   **GET /cloudvendor/{vendorId}**: Retrieves a cloud vendor by ID.
    -   Example: `GET /cloudvendor/1`
-   **GET /cloudvendor**: Retrieves all cloud vendors.
    -   Example: `GET /cloudvendor`
-   **POST /cloudvendor**: Creates a new cloud vendor.
    -   Request body (JSON):

        ```json
        {
          "vendorName": "Example Vendor",
          "vendorAddress": "123 Example Street",
          "vendorPhoneNumber": "123-456-7890"
        }
        ```

-   **PUT /cloudvendor/{vendorId}**: Updates an existing cloud vendor.
    -   Request body (JSON):

        ```json
        {
          "vendorName": "Updated Vendor Name",
          "vendorAddress": "Updated Address",
          "vendorPhoneNumber": "987-654-3210"
        }
        ```

-   **DELETE /cloudvendor/{vendorId}**: Deletes a cloud vendor by ID.
    -   Example: `DELETE /cloudvendor/1`

## Testing

The project includes unit tests written with JUnit and Mockito. To run the tests:

```bash
mvn test