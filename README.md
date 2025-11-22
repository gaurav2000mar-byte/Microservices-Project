# 📘 Student Management System – Microservices Architecture

A complete production-style microservices project built using **Spring Boot, Spring Cloud, Eureka, API Gateway, Spring Security + JWT, MySQL**—following modern industry standards.

This project contains the following microservices:

```
Microservices-Project
│
├── Eureka-Server
├── API-Gateway
├── Auth-Service (spring-security)
└── Student-Service
```

---

## 🚀 Project Overview

This system manages student data securely using microservices.  
Flow: **Client → API Gateway → Auth-Service (JWT) → Student-Service**

This demonstrates:

- ✔ Microservices Architecture  
- ✔ Service Discovery (Eureka)  
- ✔ API Gateway Routing  
- ✔ JWT Authentication & Role-Based Access  
- ✔ MySQL Database Integration  
- ✔ Validation & Exception Handling  
- ✔ REST Communication  

---

## 🏗 Microservices Included

### **1️⃣ Eureka Server**
- Service Registry
- All services register here  
- Port: **8761**

### **2️⃣ API Gateway**
- Single entry point  
- Handles routing & authentication  
- Communicates with Eureka  

### **3️⃣ Auth-Service (spring-security)**
- User Registration  
- User Login  
- JWT Generation  
- Role-based access  
- Stores users in MySQL  

### **4️⃣ Student-Service**
- CRUD operations  
- Search / Pagination  
- Protected by JWT  
- Delete allowed only for ADMIN  
- MySQL Database  

---

## 🧩 High-Level Architecture

```
                +-----------------------+
                |   Client (UI/Postman) |
                +-----------+-----------+
                            |
                            v
                 +----------+----------+
                 |      API Gateway    |
                 |        (8080)       |
                 +----------+----------+
                            |
       -------------------------------------------------
       |                       |                       |
       v                       v                       v
+-------------+      +----------------+      +----------------+
| Eureka      |      | Auth-Service   |      | Student-Service|
| Server      |      |  (JWT + MySQL) |      |   (MySQL)      |
|   (8761)    |      +----------------+      +----------------+
+-------------+
```

---

## 🔐 Authentication Flow (JWT)

1. User registers → `/auth/register`
2. User logs in → `/auth/login`
3. Token is returned
4. Every protected API must include:

```
Authorization: Bearer <token>
```

---

## 📦 Technologies Used

- Java 17  
- Spring Boot 3.5  
- Spring Cloud 2025  
- Spring Cloud Gateway  
- Spring Security (JWT)  
- Spring Data JPA  
- MySQL  
- JJWT  
- Lombok  
- Maven  

---

## ⚙️ How to Run the Project

### **1️⃣ Start Eureka Server**
```
cd Eureka-Server
mvn spring-boot:run
```

### **2️⃣ Start Auth-Service**
```
cd spring-security
mvn spring-boot:run
```

### **3️⃣ Start Student-Service**
```
cd Student-Service
mvn spring-boot:run
```

### **4️⃣ Start API Gateway**
```
cd API-Gateway
mvn spring-boot:run
```

---

## 📌 API Endpoints

### **Auth-Service**

#### Register
```
POST /auth/register
{
  "username": "john",
  "password": "1234",
  "roles": "ROLE_ADMIN"
}
```

#### Login (returns JWT)
```
POST /auth/login
{
  "username": "john",
  "password": "1234"
}
```

---

### **Student-Service (Protected)**

#### Create
```
POST /api/student/create
```

#### Get All
```
GET /api/student/all/student
```

#### Get By ID
```
GET /api/student/get/student/{id}
```

#### Update
```
PUT /api/student/update/student/{id}
```

#### Delete (Admin Only)
```
DELETE /api/student/delete/{id}
```

---

## 🗃 Database Structure

### Users Table (Auth-Service)
- id  
- username  
- password  
- roles  

### Students Table
- id  
- name  
- email  
- age  
- course_ids (stored as list)  

---

## 🛡 Security Features

- JWT Authentication  
- Role Based Authorization  
- Global Exception Handling  
- Bean Validation  

---

## 📄 Folder Structure

```
Microservices-Project/
│
├── Eureka-Server/
├── API-Gateway/
├── spring-security/
└── Student-Service/
```

---

## 🎯 Why This Project Is Great for Resume

- ✔ Real-world microservices  
- ✔ Proper Spring Cloud integration  
- ✔ Gateway + Eureka + JWT  
- ✔ Clean folder structure  
- ✔ Industry-standard development  
- ✔ Perfect for backend developer interviews  

---

## 🙌 Author

**Gaur Gopal**  
Java Backend Developer | Spring Boot | Microservices

---

