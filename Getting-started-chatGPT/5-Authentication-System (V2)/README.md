# 📌 Authentication System – Spring Boot

A professional Authentication REST API built with Spring Boot, MySQL, JPA, and BCrypt password encryption.

This project demonstrates real-world backend architecture including:

* Layered architecture (Controller → Service → Repository)
* DTO pattern
* Password encryption with BCrypt
* Validation
* Global exception handling
* MySQL integration
* RESTful API design

---

# 🚀 Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* Spring Security (BCrypt)
* MySQL
* Maven
* Postman (for testing)

---

# 📂 Project Structure

```
src/main/java/com/example/auth
│
├── config          → Security configuration
├── controller      → REST controllers
├── dto             → Request & Response DTOs
├── entity          → JPA entities
├── exception       → Global exception handling
├── repository      → Database layer
├── service         → Business logic
```

---

# ⚙️ Setup Instructions

## 1️⃣ Clone the repository

```
git clone <your-repo-url>
```

## 2️⃣ Create MySQL Database

```sql
CREATE DATABASE auth_project;
```

## 3️⃣ Configure application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/auth_project
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace `YOUR_PASSWORD` with your MySQL password.

## 4️⃣ Run the Application

Run the main class from IntelliJ or:

```
mvn spring-boot:run
```

Server will start on:

```
http://localhost:8080
```

---

# 🔐 API Endpoints

## 🔹 Register User

**POST** `/auth/register`

### Request Body

```json
{
  "email": "user@gmail.com",
  "password": "1234"
}
```

### Response

```
201 CREATED
{
  "message": "User registered successfully"
}
```

---

## 🔹 Login User

**POST** `/auth/login`

### Request Body

```json
{
  "email": "user@gmail.com",
  "password": "1234"
}
```

### Response

```
200 OK
{
  "message": "Login successful"
}
```

---

# 🔒 Security Features

* Passwords are encrypted using BCrypt.
* Raw passwords are never stored in the database.
* Validation using `@Email` and `@NotBlank`.
* Global exception handling for clean error responses.

Example encrypted password stored in DB:

```
$2a$10$XhDk39sdfkjsdfkjsdf...
```

---

# ❗ Error Handling

Example error response:

```
400 BAD REQUEST
Invalid password
```

Handled globally using `@ControllerAdvice`.

---

# 🧪 Testing

Use Postman to test endpoints:

1. Register a user
2. Login with the same credentials

---

# 🎯 What This Project Demonstrates

* Clean architecture
* Separation of concerns
* DTO usage
* Proper HTTP status codes
* Secure password handling
* Real database persistence

---

# 📌 Future Improvements

* JWT authentication
* Role-based authorization (USER / ADMIN)
* Refresh tokens
* Docker support
* Deployment to cloud

---

# 👨‍💻 Author

Built as part of backend learning journey using Spring Boot.

