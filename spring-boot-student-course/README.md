# Spring Boot Student & Course CRUD

This project includes:
- Student entity with a POST endpoint that checks if a student with the same email already exists. If so, returns a 400 response with message "The student already exists".
- Course entity with full CRUD endpoints.

Run with:
1. Java 17 and Maven installed.
2. `mvn spring-boot:run`

By default the app uses H2 in-memory database. To use MySQL, update `src/main/resources/application.properties` or create an `application-mysql.properties` and run with `--spring.profiles.active=mysql`.

API Endpoints (base `/api`):
- Students:
  - `POST /api/students` : create student (validates unique email)
  - `GET  /api/students` : list all
  - `GET  /api/students/{id}` : get by id
  - `PUT  /api/students/{id}` : update
  - `DELETE /api/students/{id}` : delete

- Courses:
  - `POST /api/courses` : create course
  - `GET  /api/courses` : list all
  - `GET  /api/courses/{id}` : get by id
  - `PUT  /api/courses/{id}` : update
  - `DELETE /api/courses/{id}` : delete
