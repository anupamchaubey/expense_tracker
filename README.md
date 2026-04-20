# 💰 Smart Expense Tracker API

A backend application built using Spring Boot to manage personal expenses efficiently.
It provides REST APIs for user management, expense tracking, and summary analysis.

---

## 🚀 Features

* 👤 User Registration & Login
* 💸 Add and View Expenses
* 🔗 User ↔ Expense Relationship (One-to-Many)
* 📊 Monthly Expense Summary (Category-wise + Total)
* ⚠️ Global Exception Handling
* ✅ Input Validation using `@Valid`

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot
* **Database:** MySQL
* **ORM:** Spring Data JPA (Hibernate)
* **Build Tool:** Maven
* **Testing Tool:** Postman

---

## 📂 Project Structure

```
com.anupam.expense_tracker
│
├── controller
├── service
├── repository
├── model
├── exception
```

---

## ⚙️ API Endpoints

### 🔐 User APIs

| Method | Endpoint              | Description       |
| ------ | --------------------- | ----------------- |
| POST   | `/api/users/register` | Register new user |
| POST   | `/api/users/login`    | Login user        |

---

### 💸 Expense APIs

| Method | Endpoint                         | Description      |
| ------ | -------------------------------- | ---------------- |
| POST   | `/api/expenses/{userId}`         | Add expense      |
| GET    | `/api/expenses/{userId}`         | Get all expenses |
| GET    | `/api/expenses/summary/{userId}` | Get summary      |

---

## 📥 Sample Requests

### 🔹 Register User

```json
{
  "name": "Anupam",
  "email": "anupam@gmail.com",
  "password": "1234"
}
```

---

### 🔹 Add Expense

```json
{
  "amount": 500,
  "category": "Food",
  "description": "Pizza"
}
```

---

## 📤 Sample Response (Summary)

```json
{
  "Food": 700,
  "Travel": 300,
  "total": 1000
}
```

---

## ⚠️ Error Handling

All errors are handled globally using `@RestControllerAdvice`.

Example:

```json
{
  "message": "User not found",
  "status": 404
}
```

---

## ✅ Validation

* Email format validation
* Required fields validation
* Password length validation

---

## ▶️ How to Run

1. Clone the repository
2. Create MySQL database:

   ```sql
   CREATE DATABASE expense_tracker;
   ```
3. Configure `application.properties`
4. Run the Spring Boot application

---

## 📌 Future Improvements

* JWT Authentication
* Pagination & Filtering
* Docker Deployment

---

## 👨‍💻 Author

**Anupam Chaubey**

---
