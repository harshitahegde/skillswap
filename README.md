# SkillSwap - Peer-to-Peer Skill Exchange Platform

A production-ready REST API built with **Spring Boot 2.7.14** and **MySQL** for exchanging and learning skills between peers. Perfect for your portfolio and resume!

## 🎯 Project Overview

SkillSwap is a skill exchange platform that enables users to:
- ✅ Create profiles and showcase expertise
- ✅ Offer skills they want to teach
- ✅ Request skills they want to learn
- ✅ Connect with skill experts
- ✅ Rate and review exchanges
- ✅ Track exchange history

## 🏗️ Tech Stack

**Backend:**
- Spring Boot 2.7.14
- Spring Data JPA with Hibernate
- Spring Security with JWT
- MySQL 8.0
- Swagger/Springfox 3.0

**Testing:**
- JUnit 5
- Mockito
- JaCoCo

## 📋 Prerequisites

- Java 11+
- Maven 3.6+
- MySQL 8.0+

## 🚀 Quick Start

### 1. Clone Repository
```bash
git clone https://github.com/harshitahegde/skillswap.git
cd skillswap
```

### 2. Create Database
```bash
mysql -u root -p
CREATE DATABASE skillswap;
```

### 3. Configure Application
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/skillswap
spring.datasource.username=root
spring.datasource.password=your_password
```

### 4. Build & Run
```bash
mvn clean install
mvn spring-boot:run
```

### 5. Access Application
- **API:** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html

## 📡 Key API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Login & get JWT token

### Users
- `GET /api/users/{id}` - Get user profile
- `PUT /api/users/{id}` - Update profile
- `GET /api/users/search?skill=Java` - Search users

### Skills
- `POST /api/skills` - Create skill
- `GET /api/skills/{id}` - Get skill details
- `GET /api/users/{id}/skills` - Get user's skills

### Skill Requests
- `POST /api/requests` - Create request
- `GET /api/requests/{id}` - Get request details
- `PUT /api/requests/{id}/status` - Update status

### Ratings
- `POST /api/ratings` - Create rating
- `GET /api/users/{id}/ratings` - Get user ratings

## 🧪 Testing

```bash
mvn test
mvn test jacoco:report
```

## 🔐 Security

- JWT token-based authentication
- BCrypt password hashing
- Role-based access control (USER, ADMIN)
- Global exception handling

## 📚 Project Structure

```
src/main/java/com/skillswap/
├── config/          # Spring Security & Swagger config
├── controller/      # REST endpoints
├── service/         # Business logic
├── repository/      # Database access
├── model/           # Entity classes
├── dto/             # Data transfer objects
├── exception/       # Custom exceptions
└── security/        # JWT & Auth
```

## 💡 Features Showcased

- RESTful API design
- Spring Boot best practices
- Database design & normalization
- JWT authentication
- Exception handling
- API documentation
- Testing strategies

## 📄 License

MIT License

---

**Version:** 1.0.0 | **Last Updated:** July 2026
