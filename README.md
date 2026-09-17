# 📦 Product API - Spring Boot & PostgreSQL

This is a practical project of a RESTful API built with **Java** and **Spring Boot**, connected to a **PostgreSQL** relational database, and secured with **JWT authentication** via Spring Security.

🌱 **About this project:** This repository marks my **first hands-on experience** with the Spring Boot framework. The main goal was to understand the basics of data persistence (CRUD) using JPA and Hibernate, and I later expanded it to include authentication and authorization with Spring Security and JWT. I am using this project as a study lab and I intend to dive deeper and deeper into the Spring ecosystem!

## 🛠️ Technologies Used

*   **Java**
*   **Spring Boot** (Web, Data JPA, Security)
*   **Spring Security** (Authentication & Authorization)
*   **JWT** (JSON Web Token, via `jjwt`)
*   **PostgreSQL** (Database)
*   **Hibernate** (ORM)
*   **BCrypt** (Password hashing)
*   **Insomnia** (For API testing and sending JSON requests)

## 🚀 How to run the project locally

### Prerequisites
Before you begin, you will need to have the following installed on your machine:
*   [Java JDK](https://www.oracle.com/java/technologies/downloads/) (version 17 or higher recommended)
*   [PostgreSQL](https://www.postgresql.org/download/)
*   An IDE of your choice (IntelliJ IDEA, Eclipse, VS Code)

### Step by Step

1. **Clone this repository:**
   ```bash
   git clone https://github.com/andynnnfw/spring-rest-api-postgres.git
   ```

2. **Configure the Database:**
   Open pgAdmin or your PostgreSQL terminal and create a database named `meubanco`:
   ```sql
   CREATE DATABASE meubanco;
   ```

3. **Configure the credentials:**
   Open the `src/main/resources/application.properties` file and change the username and password to your local PostgreSQL credentials:
   ```properties
   spring.datasource.username=your_username_here
   spring.datasource.password=your_password_here
   ```

4. **Start the application:**
   Run the project through your IDE or by using Maven. The API will be running at `http://localhost:8080`.

## 🔐 Authentication

This API uses **JWT (JSON Web Token)** for stateless authentication. Passwords are hashed with **BCrypt** before being stored in the database, and most routes require a valid token to be accessed — except for the `/auth/**` endpoints, which are public.

### Register
*   **Route:** `POST /auth/register`
*   **Description:** Creates a new user with an encrypted password.
*   **Request Body (JSON):**
    ```json
    {
      "username": "andyn",
      "password": "yourpassword"
    }
    ```
*   **Success Response:** `200 OK`

### Login
*   **Route:** `POST /auth/login`
*   **Description:** Validates the credentials and returns a JWT token to be used in protected routes.
*   **Request Body (JSON):**
    ```json
    {
      "username": "andyn",
      "password": "yourpassword"
    }
    ```
*   **Success Response:** `200 OK`
    ```json
    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
    }
    ```
*   **Error Response:** `401 Unauthorized` if credentials are invalid.

### Using the token
For protected routes, include the token in the `Authorization` header:
```
Authorization: Bearer <your_token_here>
```

## 📍 API Endpoints

Below are the available routes in the application:

### List Products
*   **Route:** `GET /api/produtos`
*   **Description:** Returns a list of all products registered in the database.
*   **Success Response:** `200 OK`

### Get Product by ID
*   **Route:** `GET /api/produtos/{id}`
*   **Description:** Returns a single product by its ID.
*   **Success Response:** `200 OK`
*   **Error Response:** `404 Not Found` if the product doesn't exist.

### Create Product
*   **Route:** `POST /api/produtos`
*   **Description:** Saves a new product in the database.
*   **How to test:** During development, I used **Insomnia** to test this endpoint, sending the product structure in JSON format through the request Body.
*   **Request Body (JSON):**
    ```json
    {
      "nome": "chocolati",
      "preco": 6.70
    }
    ```
*   **Success Response:** `200 OK` or `201 Created`

### Delete Product
*   **Route:** `DELETE /api/produtos/{id}`
*   **Description:** Removes a product from the database by its ID.
*   **Success Response:** `204 No Content`
*   **Error Response:** `404 Not Found` if the product doesn't exist.

## ⚠️ Error Handling

The API has a global exception handler that returns structured error responses instead of default stack traces, for example:

```json
{
  "timestamp": "2026-09-17T12:00:00",
  "status": 404,
  "error": "recurso nao encontrado",
  "message": "produto com ID: 99 nao encontrado"
}
```
