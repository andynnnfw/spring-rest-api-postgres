# 📦 Product API - Spring Boot & PostgreSQL

This is a practical project of a RESTful API built with **Java** and **Spring Boot**, connected to a **PostgreSQL** relational database. 

🌱 **About this project:** This repository marks my **first hands-on experience** with the Spring Boot framework. The main goal was to understand the basics of data persistence (CRUD) using JPA and Hibernate. I am using this project as a study lab and I intend to dive deeper and deeper into the Spring ecosystem!

## 🛠️ Technologies Used

*   **Java**
*   **Spring Boot** (Web, Data JPA)
*   **PostgreSQL** (Database)
*   **Hibernate** (ORM)
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
   git clone https://github.com/andy/product-api-springboot.git
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

## 📍 API Endpoints

Below are the available routes in the application:

### List Products
*   **Route:** `GET /api/produtos`
*   **Description:** Returns a list of all products registered in the database.
*   **Success Response:** `200 OK`

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
