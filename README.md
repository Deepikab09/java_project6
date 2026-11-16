
# User Management REST API

## Project Overview

The User Management REST API is a Java-based web application
developed using Spring Boot.

It allows users to perform CRUD operations such as creating,
viewing, updating, and deleting user records.

The project follows MVC architecture and uses Spring Data JPA
and Hibernate for database management.

## Technologies Used

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- REST API
- Postman

## Features

1. Create a new user.
2. Retrieve all users.
3. Retrieve a user using ID.
4. Update user information.
5. Delete a user.
6. Input validation.
7. Custom exception handling.
8. Database integration.

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/users | Create user |
| GET | /api/users | Get all users |
| GET | /api/users/{id} | Get user by ID |
| PUT | /api/users/{id} | Update user |
| DELETE | /api/users/{id} | Delete user |

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or Eclipse.
3. Make sure Java 17 and Maven are installed.
4. Run the Maven command:

   mvn clean install

5. Start the application:

   mvn spring-boot:run

6. The application runs at:

   http://localhost:8080

## H2 Database Console

Open:

http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:userdb

Username: sa

Password: (leave empty)

## Testing

Use Postman to test all CRUD API endpoints.

## Architecture

Controller -> Service -> Repository -> Database

## Author

Deepika B

## License

This project is created for educational purposes.
