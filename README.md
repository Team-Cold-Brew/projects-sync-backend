# 💻 ProjectSync - Backend (Spring Boot + MySQL)

## 🌟 Project Overview

ProjectSync is an internal management system designed to register, list, update, and delete (CRUD) organizational projects. This repository contains the RESTful API service built with Spring Boot to manage business logic and data persistence.

### Key Technologies

* **Language:** Java 21
* **Framework:** Spring Boot 3+ (Web, Data JPA, Validation)
* **Database:** MySQL 8
* **ORM:** JPA / Hibernate
* **Server:** Embedded Tomcat (Default Port: `http://localhost:8080`)

## 🛠️ Backend Configuration and Setup

### 1. Prerequisites

Make sure you have the following installed:
* JDK 21 or higher
* MySQL Server 8.0 or higher
* An IDE (IntelliJ IDEA, VS Code, Eclipse) with Spring Boot/Maven support

### 2. Database Configuration

1. Create a database on your MySQL server:

```sql
CREATE DATABASE projectsync_db;
```

2. Update the configuration file `src/main/resources/application.properties` with your credentials:

```properties
# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/projectsync_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

# JPA Configuration (Hibernate)
# spring.jpa.hibernate.ddl-auto=update (Use 'create' the first time if necessary)
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server Configuration
server.port=8080
```

### 3. Running the Project

1. Clone this repository:

```bash
git clone https://github.com/your-repository/projectsync-backend
cd projectsync-backend
```

2. Compile and run the project through your IDE or using Maven:

```bash
./mvnw spring-boot:run
```

3. The API service will be available at: `http://localhost:8080`

## 🔗 REST API Endpoints

The API manages the `Project` entity at the base endpoint `/api/projects`.

| HTTP Method | Route | Description |
|-------------|-------|-------------|
| POST | `/api/projects` | Register a new project |
| GET | `/api/projects` | List all projects |
| PUT | `/api/projects/{id}` | Update an existing project by ID |
| DELETE | `/api/projects/{id}` | Delete a project by ID |

## 🧪 Testing and Quality

The project includes unit and integration tests to ensure the reliability of CRUD operations and database connectivity.

To run all tests:

```bash
./mvnw test
```

## 🧑‍💻 Team Roles and Responsibilities

| Role | Team Member(s) | Key Responsibilities |
|------|----------------|---------------------|
| Dev1 | Emmanuel Rendon | Implementation of Create & Read (Backend + Frontend) |
| Dev2 | Juan Andres Aristizabal Vallejo | Implementation of Update & Delete (Backend + Frontend) |
| Lead/DevOps | Yeferson Alejandro Garcia Marin | Git Flow Management, Azure DevOps Traceability, Documentation, Code Review |

## 💡 Lessons Learned and Conclusions

### Key Lessons

* **Traceability Management:** Maintaining traceability between Git (commits/PRs) and Azure DevOps (Work Items) was crucial for review and progress tracking.
* **JPA Configuration:** The initial configuration of `application.properties` and Hibernate session management required special attention to ensure proper ORM mapping.
* **Separation of Responsibilities:** The division of CRUD operations (Create/Read vs. Update/Delete) between Dev1 and Dev2 enabled parallel development, but required constant synchronization through the `develop` branch.

### Conclusions

The ProjectSync project demonstrated the team's ability to implement a full-stack application, applying best practices in development (Spring Boot, JPA, Validation) and software lifecycle management (Git Flow, Azure DevOps Traceability, Code Review). A fully functional and auditable CRUD system was achieved.
