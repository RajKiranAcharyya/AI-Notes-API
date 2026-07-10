# 📝 AI Notes API

A RESTful Notes Management API built with **Spring Boot**, **Spring Data JPA**, **Hibernate**, **MySQL**, and **Google Gemini AI**.

This project allows users to create, read, update, and delete notes. It also uniquely uses **Gemini AI** to generate concise, intelligent summaries of your notes automatically.

---

## 🚀 Features

* **CRUD Operations**: Create, read, update (PUT & PATCH), and delete notes.
* **AI Integration**: Powered by Google Gemini AI for one-click note summarization.
* **Database**: Seamless MySQL database integration.
* **Architecture**: Clean RESTful API design with robust error handling and HTTP status codes (`ResponseEntity`).

---

## 🛠️ Tech Stack

* **Java 21**
* **Spring Boot** (Web, Data JPA)
* **MySQL** & **Hibernate**
* **Maven**
* **Google Gemini API**

---

## 📁 Project Structure

```text
.
├── src
│   ├── main
│   │   ├── java/com/example/ainotesapi
│   │   │   ├── AinotesapiApplication.java
│   │   │   ├── controller
│   │   │   │   └── RequestController.java
│   │   │   ├── exception
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   └── NoteNotFoundException.java
│   │   │   ├── model
│   │   │   │   └── Note.java
│   │   │   ├── repository
│   │   │   │   └── NoteRepository.java
│   │   │   └── service
│   │   │       ├── CrudServices.java
│   │   │       └── GeminiService.java
│   │   └── resources
│   │       └── application.properties
│   └── test/java/com/example/ainotesapi
│       └── AinotesapiApplicationTests.java
├── pom.xml
├── mvnw / mvnw.cmd
└── README.md
```

---

## ⚙️ Configuration

Configure your `application.properties` file with your database credentials and Gemini API key before running:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ainotesapi
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update

gemini.api.key=YOUR_GEMINI_API_KEY
```

Create a MySQL database:

```sql
CREATE DATABASE ainotesapi;
```

---

## ▶️ Getting Started

**1. Clone the repository:**

```bash
git clone https://github.com/RajKiranAcharyya/AI-Notes-API.git
```

**2. Move into the project folder:**

```bash
cd AI-Notes-API
```

**3. Run the project:**

```bash
./mvnw spring-boot:run
```
*(Or simply run the main Spring Boot application directly from your IDE).*

---

## 📌 API Endpoints

| Method | Endpoint                | Description             |
| ------ | ----------------------- | ----------------------- |
| POST   | `/notes`                | Create a note           |
| GET    | `/notes`                | Get all notes           |
| GET    | `/notes/{id}`           | Get note by ID          |
| PUT    | `/notes/{id}`           | Update a note (Full)    |
| PATCH  | `/notes/{id}`           | Update a note (Partial) |
| DELETE | `/notes/{id}`           | Delete a note           |
| POST   | `/notes/{id}/summarize` | Generate AI summary     |