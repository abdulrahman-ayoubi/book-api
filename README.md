# Enterprise Web App | Course API Lab

## Student

Abdul Rahman Ayoubi

## Project Description

This project connects a React frontend to a Spring Boot backend and displays course records retrieved from the Course API.

The React application fetches course data from:

`GET http://localhost:8080/api/v1/courses`

The courses are displayed in a table with the following columns:

* ID
* Code
* Title
* Credits

## Technologies

* React
* Vite
* Axios
* Spring Boot
* Java

## Project Ports

### Backend

* Host: `localhost`
* Port: `8080`
* API: `http://localhost:8080/api/v1/courses`

### Frontend

* Host: `localhost`
* Port: `5173`
* URL: `http://localhost:5173`

## How to Run

### 1. Start the Backend

Open a terminal in the Spring Boot project:

```bash
cd "/mnt/f/Kabul university/7/Enterprise /demo/book-api"
```

Run:

```bash
./mvnw spring-boot:run
```

If the Maven wrapper is not available, use:

```bash
mvn spring-boot:run
```

The backend should run on:

```text
http://localhost:8080
```

### 2. Start the React Frontend

Open another terminal in the React project:

```bash
cd "/mnt/f/Kabul university/7/Enterprise /compushub-ui"
```

Install dependencies if needed:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The frontend should run on:

```text
http://localhost:5173
```

## API

The frontend uses Axios to request:

```text
GET http://localhost:8080/api/v1/courses
```

The backend returns course records containing:

```text
id
code
title
credits
```

## React State and API Handling

The `Courses` component uses `useState` to store:

* course data
* loading status
* error status

It uses `useEffect` to request the course data when the component is mounted.

The component also handles:

* Loading state
* Error state
* Empty course list
* Successful course list
* Total course count

## Submission Evidence

The submission includes:

1. Screenshot of the populated course table.
2. Screenshot of the visible error state.
3. Screenshot of the successful `GET /api/v1/courses` request in the browser Network tab or Postman.

## Questions

### 1. Why use `useEffect` here?

`useEffect` is used because fetching data from the backend is a side effect. It allows the React component to request the course data after the component is mounted.

### 2. What does `setCourses` do?

`setCourses` updates the React state that stores the list of courses. When the state is updated, React re-renders the component and displays the received course records in the table.

### 3. Why can Postman work while a browser request fails?

Postman is not restricted by browser security policies such as CORS. A browser request from the React frontend is subject to CORS rules, so the backend must allow requests from the frontend origin. Therefore, an API can work in Postman while a browser request fails because of CORS or another browser-side restriction.
