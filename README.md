# Enterprise Web App | Course API Lab

## Student

Abdul Rahman Ayoubi

## Project Description

This project provides a Spring Boot REST API for the Enterprise Web App Course API Lab.

The backend provides course data through the following endpoint:

`GET http://localhost:8080/api/v1/courses`

## Technologies

* Java
* Spring Boot
* Spring Web

## Backend Port

The Spring Boot backend runs on:

`http://localhost:8080`

## API Endpoint

### Get All Courses

**GET**

`http://localhost:8080/api/v1/courses`

The endpoint returns a list of courses containing:

* ID
* Code
* Title
* Credits

## Example Response

```json
[
  {
    "id": 1,
    "code": "EWA301",
    "title": "Enterprise Web App",
    "credits": 3
  },
  {
    "id": 2,
    "code": "DB201",
    "title": "Database Systems",
    "credits": 3
  },
  {
    "id": 3,
    "code": "SE202",
    "title": "Software Engineering",
    "credits": 3
  }
]
```

## CORS

The Course API allows requests from the React development server:

`http://localhost:5173`

This allows the React frontend to request course data from the Spring Boot backend.

## How to Run

Open a terminal in the backend project:

```bash
cd "/mnt/f/Kabul university/7/Enterprise /demo/book-api"
```

Run the application:

```bash
./mvnw spring-boot:run
```

If Maven Wrapper is not available:

```bash
mvn spring-boot:run
```

The API will be available at:

`http://localhost:8080/api/v1/courses`

