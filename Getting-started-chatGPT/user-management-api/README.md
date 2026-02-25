
# 🚀 Level Up: User Management System (Real Backend Style)

YES 🔥🔥🔥
Now we’re talking.

You’ve already built:

* Basic REST API
* Layered architecture
* JPA + H2
* Git + GitHub

Now it’s time to level up 🚀

---

## 🏆 Next Project

**User Management System** — Real Backend Style

This will introduce:

* DTOs
* Validation
* Exception handling
* Proper HTTP status codes
* Clean architecture
* Better REST design

---

## 🧠 What You Will Learn

This project adds:

* ✅ DTO pattern (important in real companies)
* ✅ Request validation (`@Valid`)
* ✅ Global exception handling
* ✅ Proper REST responses
* ✅ Clean response structure
* ✅ Optional custom queries

This is where you start becoming a backend developer.

---

## 🧠 What is Entity?

Entity = Represents a table in database.

Example:

Table: `student`
Columns:

* id
* name
* email

---

## 🧠 What is Repository?

Repository = Talks directly to database.

Spring automatically gives you:

* `save()`
* `findAll()`
* `findById()`
* `deleteById()`

WITHOUT writing SQL 😎

---

## 🧠 What is DTO (VERY IMPORTANT)

DTO = **Data Transfer Object**

It is used to:

* Control what data enters your system
* Control what data leaves your system
* Hide internal structure

⚠️ We NEVER expose Entity directly in professional projects.

Example:

* What if client sends ID manually? ❌
* With DTO: client can ONLY send `name` and `email`
* Backend controls ID

🔥 Security + clean architecture.

---

# 📌 Key Annotations

### 1️⃣ `@RestController`

```java
@RestController
```

What it means:

* Tells Spring: "This class handles HTTP requests and returns JSON responses."
* Combination of: `@Controller` + `@ResponseBody`

Without it:

* Spring thinks you are returning HTML pages (old MVC style)

Example:

```java
return new Student("Ali", "ali@email.com");
```

Spring automatically converts to JSON:

```json
{
  "id": 1,
  "name": "Ali",
  "email": "ali@email.com"
}
```

Conversion is done by **Jackson** automatically.

---

### 2️⃣ `@RequestMapping("/students")`

```java
@RequestMapping("/students")
```

* Sets the **base URL** for all methods in this controller
* All endpoints start with `/students`

Without it, you’d write:

```java
@PostMapping("/students")
@GetMapping("/students")
@GetMapping("/students/{id}")
```

With it, your code is cleaner.

---

### 3️⃣ `@PostMapping`

```java
@PostMapping
```

* Handles HTTP **POST** requests
* Used for **creating data** with JSON body

Example:

```
POST /students
```

---

### 4️⃣ `@GetMapping`

```java
@GetMapping
```

* Handles HTTP **GET** requests

Examples:

```
GET /students
GET /students/1
```

Used for fetching data.

---

### 5️⃣ `@RequestBody`

```java
public Student createStudent(@RequestBody StudentDTO dto)
```

* Tells Spring: "Take the JSON from request body and convert to Java object"

Example JSON body:

```json
{
  "name": "Ali",
  "email": "ali@email.com"
}
```

Spring converts this to `StudentDTO dto`.

Without `@RequestBody`, Spring won’t read JSON.

---

### 6️⃣ `@PathVariable`

```java
@GetMapping("/{id}")
public Student getStudentById(@PathVariable Long id)
```

* Extracts value from **URL**

Example:

```
GET /students/5
```

* Spring takes `5`
* Puts it in `Long id`

---

## 🔥 Visual Flow

Example:

```
GET /students/10
```

Flow:

1. Spring matches `/students/{id}`
2. Extracts `10`
3. Puts it in `id`
4. Calls method
5. Returns JSON

