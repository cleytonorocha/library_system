# Library API
The <strong>Library API</strong> is a robust solution for managing products and services for a large bookstore. It provides an efficient way to handle inventory, customer transactions, and product acquisitions using advanced database techniques, ensuring a seamless experience across various features.
##### deploy: https://library.cleytonorocha.com.br/swagger-ui/index.html#/
## Features
- Authentication and Authorization: Secure endpoints using JWT.
- Product Management: Full CRUD for bookstore products, organized by categories.
- Product Acquisitions:
  - Shopping Cart: Add and manage products in a shopping cart.
  - Payment Status: Track the status of product payments.
  - Acquisition Types: Different methods of acquiring products.
- Customer and User Management: Customers and users are closely linked to all other entities, enabling a connected and coherent system.
- Inheritance for Product Acquisitions: Advanced database inheritance techniques are used for product acquisitions, allowing different types of purchases to be managed efficiently.
- Data Validation: Validation of data on creation and update operations.
- Environment Configurations: Separate environment profiles for development and production.

## Project Structure
    The project uses three configuration files:

    - application-dev.properties: Development environment settings.
    - application-prod.properties: Production environment settings.
    - application.properties: Defines the active profile (development or production).

## Architecture
### UML Diagram

![diagram](https://github.com/Cleyton-ORocha/library_system/assets/114354149/e3be5d62-cef4-4752-8094-2ca842386c0f)

### Layered Architecture
The application follows a layered architecture to maintain organization and modularity:

  - Controller: API endpoints, handling HTTP requests.
  - Service: Business logic and application rules.
  - Repository: Data access using Spring Data JPA.
  - Model: Definitions of entities and their relationships.
### Entity Relationships
    
  - Inheritance: Entities use @Inheritance(strategy = InheritanceType.JOINED) to model inheritance in the database.
  - PostgreSQL: Database used for data persistence.

## Technologies
### Backend
  - Java: Primary programming language.
  - Object-Oriented Programming (OOP)
  - Functional Programming
  - Enums and Custom Exceptions
  - Spring Boot: Main framework for application development.
  - Spring Security 6: JWT-based authentication and authorization.
  - Spring Data JPA: Database integration using JPA.
  - Hibernate: ORM framework for data persistence.
  - Lombok: Reduces boilerplate code (getters, setters, etc.).
  - Docker: Containerization to ensure consistent environments.
### Database
  - PostgreSQL: Relational database used to store application data.
## Project Setup
### Prerequisites
  - Java 17+
  - Maven 3.8+
  - Docker (to run the application via containers)
  - PostgreSQL (if running locally without Docker)
## How to Run
### Clone the repository:

    git clone https://github.com/Cleyton-ORocha/library_system.git
    cd library_system
    Build the project with Maven:

    mvn clean package
    Run with Docker Compose:

    docker-compose up
    Running locally:

    Ensure PostgreSQL is running on the correct port.
    Configure the application.properties:
    properties
    Copiar código
    spring.datasource.url=jdbc:postgresql://localhost:5432/library
    spring.datasource.username=your_user
    spring.datasource.password=your_password

## Access the API:

    The application will be available at: https://localhost:8080 and swagger on https://localhost:8080/swagger-ui/index.html#/.
