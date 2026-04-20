# Fitness Warehouse

Fitness Warehouse is a web-based inventory management system built with Spring Boot for CPAN-228 Web Application Development. The application allows users to view products, add new products through a form, validate user input, and browse saved records using filtering and sorting features.

## Features

- Home page with project overview
- About page describing the application
- Products list page with pagination
- Add / Edit / Delete Product (admin only)
- Server-side validation with clear error messages
- User registration and login with Spring Security
- Role-based access control (USER / ADMIN)
- H2 database persistence using Spring Data JPA
- Sample product data loaded on startup using `data.sql`
- Filtering by brand and category
- Sorting by name and price
- Bootstrap styling with a custom red-and-white futuristic fitness theme

## Technologies Used

- Java 17
- Spring Boot 4.0
- Spring Web MVC
- Thymeleaf
- Spring Data JPA
- H2 Database (development)
- MySQL 8.0 (QA / Docker)
- Spring Validation
- Spring Security
- Bootstrap 5
- Custom CSS
- Docker & Docker Compose

## Environment Profiles

The application supports multiple environment profiles — no code changes are needed to switch:

| Profile | Database | Activated By |
|---------|----------|--------------|
| `dev` (default) | H2 in-memory | `spring.profiles.active=dev` |
| `qa` | MySQL via Docker | `spring.profiles.active=qa` |

### Development (H2)

Run the application with the default dev profile:

```bash
./mvnw spring-boot:run
```

The H2 console is available at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:fitnessdb`).

### QA (MySQL via Docker)

See the Docker section below.

## How to Run with Docker

### Prerequisites

- [Docker](https://www.docker.com/get-started) installed and running

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-org/spring-booters.git
   cd spring-booters
   ```

2. Build and start the application and MySQL database:
   ```bash
   docker compose up --build
   ```

3. Open `http://localhost:8080` in your browser.

4. To stop the containers:
   ```bash
   docker compose down
   ```

5. To stop and remove all data (reset the database):
   ```bash
   docker compose down -v
   ```

### Environment Variables

The following environment variables are configured in `docker-compose.yml` and can be overridden:

| Variable | Default | Description |
|----------|---------|-------------|
| `SPRING_PROFILES_ACTIVE` | `qa` | Active Spring profile |
| `MYSQL_HOST` | `mysql` | MySQL hostname |
| `MYSQL_PORT` | `3306` | MySQL port |
| `MYSQL_DATABASE` | `fitnessdb` | Database name |
| `MYSQL_USER` | `fitnessuser` | Database username |
| `MYSQL_PASSWORD` | `fitnesspass` | Database password |

## How to Run Locally (without Docker)

1. Clone the repository
2. Open the project using a Java IDE
3. Run `FitnessWarehouseApplication.java`
4. Open `http://localhost:8080` in your browser

## Pages

- `/` - Home page
- `/about` - About page
- `/products` - Product list with filtering and sorting
- `/products/new` - Add Product form
- `/login` - Login page
- `/register` - Registration page

## Team Members and Roles

- **Julila Mpesha** — Backend architecture, data model, validation, persistence, service logic
- **Ben Aharon** — Frontend layout, Thymeleaf templates, forms, styling
- **Brayden Bourgeois** — Controllers, routing, application flow, security integration

## Current Deliverable

This version demonstrates the Deliverable 1 requirements for:
- navigation and pages
- a working form
- validation
- database persistence
- list view with search and sort
- sample data on startup
- Bootstrap-based styling
