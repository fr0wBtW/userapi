Spring Boot REST API for managing users with CRUD operations, validation, and exception handling.

\Features

\- Create, Read, Update, Delete (CRUD) users

\- Input validation (`@NotBlank`, `@Min`, `@Max`)

\- Global exception handling for validation errors and not found users

\- H2 in-memory database (for testing)

\- REST endpoints:
 
`GET /users` → list all users

`GET /users/{id}` → get user by id

`POST /users` → create new user

`PUT /users/{id}` → update user

`DELETE /users/{id}` → delete user


Technologies

\- Java 17

\- Spring Boot 4

\- Spring Data JPA / Hibernate

\- H2 Database

\- Maven

