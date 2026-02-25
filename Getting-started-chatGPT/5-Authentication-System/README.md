Here is your cleaned and well-structured **README.md** version, ready to paste into GitHub:

---

# 🔐 Spring Boot Authentication Project

This project is a simple authentication system built with **Spring Boot**, **JPA**, and **MySQL**.
It supports:

* ✅ User Registration
* ✅ User Login
* ✅ Database Integration
* ✅ Clean Architecture using DTOs

---

# 🧠 Why `@Table(name = "users")`?

```java
@Table(name = "users")
```

The word `user` is a reserved keyword in some databases.

To avoid SQL conflicts, we rename the table to:

```
users
```

---

# 🧠 Why `@Column(unique = true)`?

```java
@Column(unique = true)
private String email;
```

This ensures:

* ❌ No duplicate emails
* ✅ Database-level validation

---

# 🧠 Why Multiple DTOs?

We use multiple DTOs because:

* Register and Login return different responses
* We NEVER return the password
* We control the API response format
* This follows clean architecture principles

---

# 📦 UserRepository Explained

```java
package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
```

---

## 🔹 What is `JpaRepository<User, Long>`?

```java
extends JpaRepository<User, Long>
```

This means:

* The repository works with the `User` entity
* The ID type of `User` is `Long`

From the entity:

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

---

## 🔹 What Does JpaRepository Give You For Free?

By extending `JpaRepository`, you automatically get:

```java
save(user)
findById(id)
findAll()
deleteById(id)
existsById(id)
count()
```

You write ZERO SQL.

Example:

```java
repository.findById(1L);
```

Spring automatically generates:

```sql
SELECT * FROM users WHERE id = 1;
```

---

## 🔥 Derived Query Method

```java
Optional<User> findByEmail(String email);
```

Spring reads the method name and builds SQL automatically.

```java
findByEmail
```

Becomes:

```sql
SELECT * FROM users WHERE email = ?
```

No SQL written manually.

---

## 🔹 Why `Optional<User>`?

Because the user might NOT exist.

Instead of returning `null`, Spring returns:

```java
Optional<User>
```

Usage in service:

```java
repository.findByEmail(email)
        .orElseThrow(...)
```

If found → return user
If not → throw exception

This prevents `NullPointerException`.

---

## 🔹 How Spring Knows the Column Name?

From the entity field:

```java
@Column(unique = true)
private String email;
```

Spring matches:

```
findByEmail
```

With:

```
email
```

⚠️ The method name MUST match the entity field name exactly.

If the field was:

```java
private String userEmail;
```

The method must be:

```java
findByUserEmail()
```

---

# 🧪 Testing With Postman

Make sure your application is running.

---

## 🔹 Register

* Method: **POST**
* URL:

```
http://localhost:8080/auth/register
```

* Body → raw → JSON

```json
{
  "email": "ali@gmail.com",
  "password": "1234"
}
```

Click **Send**.

---

## 🔹 Login

* Method: **POST**
* URL:

```
http://localhost:8080/auth/login
```

* Body → raw → JSON

```json
{
  "email": "ali@gmail.com",
  "password": "1234"
}
```

Click **Send**.

---

# 🗄️ Connect To MySQL Database

---

## 🚀 Step 1 — Install MySQL

Download:

[https://dev.mysql.com/downloads/mysql/](https://dev.mysql.com/downloads/mysql/)

During installation:

* Remember your **root password**
* Keep default port: `3306`

---

## 🚀 Step 2 — Create Database

Open MySQL Workbench or terminal and run:

```sql
CREATE DATABASE auth_project;
```

Database name:

```
auth_project
```

---

## 🚀 Step 3 — Add MySQL Dependency (Maven)

Open `pom.xml` and add:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

Make sure you already have:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Reload Maven in IntelliJ.

---

## 🚀 Step 4 — Configure `application.properties`

Open:

```
src/main/resources/application.properties
```

Replace with:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/auth_project
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
```

⚠️ Replace `YOUR_PASSWORD` with your MySQL root password.

---

# ✅ What You Achieved

* Connected Spring Boot to a real MySQL database
* Used JPA without writing SQL
* Created derived query methods
* Built a clean authentication structure
* Tested API using Postman


